package com.room.controller.admin;

import com.room.controller.LoginModel;
import com.room.mapper.AdminInfoMapper;
import com.room.mapper.DeskInfoMapper;
import com.room.mapper.SeatInfoMapper;
import com.room.pojo.AdminInfo;
import com.room.pojo.DeskInfo;
import com.room.pojo.DeskInfoExample;
import com.room.pojo.SeatInfo;
import com.room.service.SeatInfoService;
import com.room.util.CommonVal;
import com.room.util.DataListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin/seat_info")
public class ASeatInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    SeatInfoService seatInfoService;
    @Autowired
    AdminInfoMapper adminInfoMapper;
    @Autowired
    SeatInfoMapper seatInfoMapper;

    @Autowired
    DeskInfoMapper deskInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台
        modelMap.addAttribute("deskStatusList",
                DataListUtils.getDeskStatusList()); //返回desk_status数据列表
    }

    /**
     * 返回桌子列表jsp页面
     */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        AdminInfo adminInfo = adminInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", adminInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "admin/seat_info/list";
    }

    /**
     * 根据查询条件分页查询桌子数据,然后返回给前台渲染
     */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(SeatInfo model, Integer page,
                         HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName);

        return seatInfoService.getDataList(model, page, CommonVal.pageSize,
                login); //分页查询数据
    }

    /**
     * 进入新增页面
     */
    @RequestMapping("add")
    public String add(ModelMap modelMap, SeatInfo model,
                      HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台
        modelMap.addAttribute("data", model);
        List<DeskInfo> deskInfos = deskInfoMapper.selectByExample(new DeskInfoExample());
        modelMap.addAttribute("deskInfos", deskInfos);

        return "admin/seat_info/add_page";
    }

    /**
     * 新增提交信息接口
     */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(SeatInfo model, ModelMap modelMap,
                             HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = seatInfoService.add(model, login); //执行添加操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                    "新增成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     * 进入修改页面
     */
    @RequestMapping("update")
    public String update(ModelMap modelMap, SeatInfo model,
                         HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台

        SeatInfo data = seatInfoMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "admin/seat_info/update_page";
    }

    /**
     * 修改提交信息接口
     */
    @RequestMapping("update_submit")
    @ResponseBody
    public Object update_submit(SeatInfo model, ModelMap modelMap,
                                HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = seatInfoService.update(model, login); //执行修改操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                    "修改成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     * 删除数据接口
     */
    @RequestMapping("del")
    @ResponseBody
    public Object del(Integer id, ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        seatInfoService.delete(id);
        rs.put("code", 1);
        rs.put("msg",
                "删除成功");

        return rs;
    }
}

