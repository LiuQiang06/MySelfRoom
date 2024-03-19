package com.room.service;

import com.room.controller.LoginModel;

import com.room.pojo.*;

import java.util.Map;


public interface AdminInfoService {
    /**
      分页查询管理员数据列表
    */
    public Map<String, Object> getDataList(AdminInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装管理员为前台展示的数据形式
    */
    public Map<String, Object> getAdminInfoModel(AdminInfo model,
        LoginModel login);
}

