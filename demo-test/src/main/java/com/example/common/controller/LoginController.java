package com.example.common.controller;

import com.example.menu.entity.MenuInfo;
import com.example.menu.service.MenuInfoService;
import com.example.user.entity.ManageUser;
import com.example.user.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhizhong on 2017/4/17.
 */
@Controller
@RequestMapping("/home")
public class LoginController {

    @Autowired
    private MenuInfoService menuInfoService;
    @Autowired
    private ManageUserService manageUserService;

    @RequestMapping("/index")
    public String loginPage(Map<String, Object> map) {
        System.out.println("HelloController.helloJsp().hello=" + "进入登录页");
        map.put("hello", "");
        return "page/common/login";

    }

    @RequestMapping("/login")
    public String indexPage(Map<String, Object> map,HttpServletRequest request,String userName,String userPassword) {
        System.out.println("HelloController.helloJsp().hello=" + "进入首页");
        Map<String,Object> result = manageUserService.selectUserByUserName(userName);

        //账号是否存在
        int status = (int) result.get("status");
        if(status==0){
            map.put("status",0);
            map.put("message",result.get("message"));
            return "page/common/login";
        }

        //密码是否正确
        ManageUser user = (ManageUser) result.get("manageUser");
        if(!userPassword.equals(user.getUserPassword())){
            map.put("message","密码错误");
            return "page/common/login";
        }

        //账号是否可用
        if(!"1".equals(user.getIsEnable())){
            map.put("message","账号已停用");
            return "page/common/login";
        }

        //将用户信息存入session
        request.getSession().setAttribute("user_info",user);

        //查询该用户的角色信息
        List<MenuInfo> menuList = menuInfoService.selectMeanInfoList(userName);

        map.put("userName", "admin");
        map.put("list",menuList);
        return "page/common/main";

    }

    // 后台管理退出
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 清除session
        request.getSession().removeAttribute("user_info");

        return "page/common/login";
    }
}
