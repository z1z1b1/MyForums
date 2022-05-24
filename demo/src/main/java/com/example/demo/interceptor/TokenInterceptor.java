package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.util.TokenUtil;

/**
 * @author 凌
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/user/login".equals(request.getRequestURI())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if (request.getRequestURI().contains("/css")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if (request.getRequestURI().contains("/js")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if ("/login.html".equals(request.getRequestURI())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if ("/login".equals(request.getRequestURI())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if ("/".equals(request.getRequestURI())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if ("/index.html".equals(request.getRequestURI())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if ("/error".equals(request.getRequestURI())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if ("/favicon.ico".equals(request.getRequestURI())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = null;
        try {
            token = request.getHeader("Authorization").substring(7);
        } catch (Exception e) {
            System.out.println("未设置token");
        }
        if (token != null) {
            boolean result = TokenUtil.verify(token);
            if (result) {
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            JSONObject json = new JSONObject();
            json.put("msg", "token verify fail");
            json.put("code", "50000");
            response.getWriter().append(json.toString());
            System.out.println("认证失败，未通过拦截器");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}