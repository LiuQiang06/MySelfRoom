package com.room.service;

import com.room.controller.LoginModel;

import java.util.Map;


public interface StudyGatherService {
    /**
      学习时间统计
    page:当前页数
    login:当前登录账号
    ororderDate1:预约日期(最小值)
    ororderDate2:预约日期(最大值)
    */
    public Map<String, Object> studyGather(Integer page, LoginModel login,
        String ororderDate1, String ororderDate2);
}

