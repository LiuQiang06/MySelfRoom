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
@RequestMapping("/user/desk_info")
public class UDeskInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    DeskInfoService deskInfoService;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    DeskInfoMapper deskInfoMapper;


    /**
     * 返回桌子列表jsp页面
     */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", userInfo);

        DeskInfoExample de = new DeskInfoExample();
        List<DeskInfo> dl = deskInfoMapper.selectByExample(de);
        modelMap.addAttribute("dl", dl);

        return "user/desk_info/desk_list";
    }


}

