package com.room.service.impl;

import com.room.controller.LoginModel;
import com.room.mapper.SeatInfoMapper;
import com.room.pojo.SeatInfo;
import com.room.pojo.SeatInfoExample;
import com.room.service.SeatInfoService;
import com.room.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SeatInfoServiceImpl implements SeatInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    SeatInfoMapper seatInfoMapper;

    /**
      新增
    */
    @Override
    public String add(SeatInfo model, LoginModel login) {
        if ((model.getDeskId() == null) || model.getSeatNo().equals("")) {
            return "座位号和自习室号为必填属性";
        }

        model.setDeskStatus(1); //默认空闲,
        seatInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(SeatInfo model, LoginModel login) {
        SeatInfo preModel = seatInfoMapper.selectByPrimaryKey(model.getId());

        if ((model.getDeskId() == null) || model.getSeatNo().equals("")) {
            return "座位号和自习室号为必填属性";
        }

        preModel.setDeskId(model.getDeskId());
        preModel.setSeatNo(model.getSeatNo());
        seatInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询桌子列表数据
    */
    @Override
    public Map<String, Object> getDataList(SeatInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        SeatInfoExample se = new SeatInfoExample();
        SeatInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序
        if (queryModel.getDeskId() != null && queryModel.getDeskId() != "") {
            sc.andDeskNoEqualTo(queryModel.getDeskId()); //查询当前状态等于指定值
        }

        if (queryModel.getDeskStatus() != null) {
            sc.andDeskStatusEqualTo(queryModel.getDeskStatus()); //查询当前状态等于指定值
        }

        int count = (int) seatInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<SeatInfo> list = seatInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (SeatInfo model : list) {
            list2.add(getSeatInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装桌子为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getSeatInfoModel(SeatInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("seatInfo", model);
        map.put("deskStatusStr",
            DataListUtils.getDeskStatusNameById(model.getDeskStatus() + "")); //解释当前状态字段

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        seatInfoMapper.deleteByPrimaryKey(id);
    }
}

