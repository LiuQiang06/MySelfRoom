package com.room.service;

import com.room.controller.LoginModel;

import com.room.pojo.*;

import java.util.Map;


public interface OrderInfoService {
    /**
      分页查询订单数据列表
    */
    public Map<String, Object> getDataList(OrderInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装订单为前台展示的数据形式
    */
    public Map<String, Object> getOrderInfoModel(OrderInfo model,
        LoginModel login);

    /**
      新增
    */
    public String orderDesk(OrderInfo model, LoginModel login);
}

