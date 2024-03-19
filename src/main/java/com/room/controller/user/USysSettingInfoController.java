package com.room.controller.user;

import com.room.controller.LoginModel;
import com.room.mapper.*;
import com.room.pojo.*;
import com.room.service.*;
import com.room.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user/sys_setting_info")
public class USysSettingInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    SysSettingInfoService sysSettingInfoService;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    SysSettingInfoMapper sysSettingInfoMapper;

    /**
     * 返回系统设置列表jsp页面
     */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", userInfo);
        SysSettingInfoExample se = new SysSettingInfoExample();
        List<SysSettingInfo> sl = sysSettingInfoMapper.selectByExample(se);
        SysSettingInfo sysSettingInfo = null;
        if (sl != null && sl.size() > 0) {
            sysSettingInfo = sl.get(0);
        }
        modelMap.addAttribute("setting", sysSettingInfo);
        return "user/sys_setting_info/detail";
    }

}

