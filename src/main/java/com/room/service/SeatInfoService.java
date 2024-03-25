package com.room.service;

import com.room.controller.LoginModel;
import com.room.pojo.SeatInfo;

import java.util.Map;


public interface SeatInfoService {
    /**
      分页查询桌子数据列表
    */
    public Map<String, Object> getDataList(SeatInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装桌子为前台展示的数据形式
    */
    public Map<String, Object> getSeatInfoModel(SeatInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(SeatInfo model, LoginModel login);

    /**
      修改
    */
    public String update(SeatInfo model, LoginModel login);
}

