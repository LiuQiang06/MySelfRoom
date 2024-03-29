package com.room.controller.admin;

import com.room.controller.LoginModel;

import com.room.mapper.*;

import com.room.pojo.*;

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
@RequestMapping("/admin/deposit_log")
public class ADepositLogController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    DepositLogService depositLogService;
    @Autowired
    DepositLogMapper depositLogMapper;
    @Autowired
    AdminInfoMapper adminInfoMapper;

    /**
     * 返回充值记录列表jsp页面
     */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);

        return "admin/deposit_log/list";
    }

    /**
     * 根据查询条件分页查询充值记录数据,然后返回给前台渲染
     */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(DepositLog model, Integer page,
                         HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName);

        return depositLogService.getDataList(model, page, CommonVal.pageSize,
                login); //分页查询数据
    }
}

