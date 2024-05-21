package com.room.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@Configuration
public class AutoRunWeb {

    // 这里是注入你yml配置的端口号
    @Value("${server.port}")
    private String port;

    //这里是注入你的项目访问路径
    @Value("${server.context-path}")
    private String contextPath;

    /**
     * 监听事件（当项目启动后），启动浏览器
     */
    @EventListener({ApplicationReadyEvent.class})
    void applicationReadyEvent() {

        System.out.println("应用已经准备就绪 ... 启动浏览器");

        // 需要启动的url（appPort是端口号， "/main"是接口）
        //http://localhost:port/study_room_sys/commonapi/sys_login
        String url = "http://localhost:" + port + contextPath + "/commonapi/sys_login";
        System.out.println("项目地址url：" + url);

        //调用默认浏览器，打开初始化地址url
        Runtime runtime = Runtime.getRuntime();
        try {
            // rundll32 url.dll,FileProtocolHandler是Windows系统下用来打开默认浏览器并访问指定URL的命令
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}