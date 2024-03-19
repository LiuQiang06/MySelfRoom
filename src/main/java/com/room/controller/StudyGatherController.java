package com.room.controller;

import com.room.service.*;

import com.room.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/commonapi/studyGather")
public class StudyGatherController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    StudyGatherService studyGatherService;

    /**
    进入学习时间统计页面
    */
    @RequestMapping(value = "studyGather")
    public String StudyGather(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        if (login == null) {
            modelMap.addAttribute("msg",
                "尚未登录");

            return "error";
        }

        return "study_gather";
    }

    /**
      提交学习时间统计信息接口
    */
    @RequestMapping(value = "studyGatherSubmit")
    @ResponseBody
    public Object studyGatherSubmit(Integer page, String ororderDate1,
        String ororderDate2, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        if (login == null) {
            return null;
        }

        return studyGatherService.studyGather(page, login, ororderDate1,
            ororderDate2);
    }
}

