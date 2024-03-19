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
@RequestMapping("/commonapi/orderGather")
public class OrderGatherController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    OrderGatherService orderGatherService;

    /**
    进入订单统计页面
    */
    @RequestMapping(value = "orderGather")
    public String OrderGather(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        if (login == null) {
            modelMap.addAttribute("msg", "尚未登录");

            return "error";
        }

        return "order_gather";
    }

    /**
      提交订单统计信息接口
    */
    @RequestMapping(value = "orderGatherSubmit")
    @ResponseBody
    public Object orderGatherSubmit(Integer page, String orcreateTime1,
        String orcreateTime2, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        if (login == null) {
            return null;
        }

        return orderGatherService.orderGather(page, login, orcreateTime1,
            orcreateTime2);
    }
}

