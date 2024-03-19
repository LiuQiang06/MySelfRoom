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
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user/deposit_log")
public class UDepositLogController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    DepositLogService depositLogService;
    @Autowired
    DepositLogMapper depositLogMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 返回充值记录列表jsp页面
     */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", userInfo);

        return "user/deposit_log/list";
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
        model.setUserId(login.getId()); //充值用户等于当前登录id

        return depositLogService.getDataList(model, page, CommonVal.pageSize,
                login); //分页查询数据
    }

    /**
     * 进入充值页面
     */
    @RequestMapping("deposit")
    public String deposit(ModelMap modelMap, DepositLog model,
                          HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号
        modelMap.addAttribute("data", model);

        return "user/deposit_log/deposit_page";
    }

    /**
     * 充值提交信息接口
     */
    @RequestMapping("deposit_submit")
    @ResponseBody
    public Object deposit_submit(DepositLog model, ModelMap modelMap,
                                 HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = depositLogService.deposit(model, login); //执行添加操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                    "充值成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }
}

