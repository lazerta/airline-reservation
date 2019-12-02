package com.lei.airlinereservation.interceptor;

import com.lei.airlinereservation.annotation.Login;
import com.lei.airlinereservation.common.Const;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;
            if (!method.hasMethodAnnotation(Login.class)){
                return true;
            }
             if (request.getSession().getAttribute(Const.currentUser) == null){
                 response.sendRedirect("login");
             }
        }
        return true;
    }
}
