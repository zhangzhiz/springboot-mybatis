package com.example.common.interceptor;

import com.example.common.SystemSession.SystemThreadLocal;
import com.example.user.entity.ManageUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zhangzhizhong on 2017/4/19.
 */

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (request.getServletPath().endsWith("index") || request.getServletPath().endsWith("login")) {
            return true;
        }

        HttpSession session = request.getSession();
        ManageUser user = (ManageUser) session.getAttribute("user_info");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/home/index");
            return false;
//            String requestType = request.getHeader("x-requested-with");
//            if ("XMLHttpRequest".equals(requestType)) {
//                String contentType = "application/octet-str" + "eam";
//                ServletOutputStream out = response.getOutputStream();
//                response.setContentType(contentType);
//
//                response.setHeader("sessionstatus", "timeout");
//                // out.print("parent.location.href='"+request.getContextPath()
//                // +"/login.action'");
//                out.print("<script>");
//                out.print("parent.location.href='" + request.getContextPath() + "/home/index'");
//                out.print("</script>");
//
//                //out.flush();
//            } else {
//                response.sendRedirect(request.getContextPath() + "/home/index");
//            }
        }

        SystemThreadLocal.setUserSession(user);
        return true;


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
