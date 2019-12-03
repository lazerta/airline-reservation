package com.lei.airlinereservation.interceptor;

import com.lei.airlinereservation.annotation.Admin;
import com.lei.airlinereservation.common.Const;
import com.lei.airlinereservation.entity.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;
            if (!method.hasMethodAnnotation(Admin.class)){
                return true;
            }
            User user = (User) request.getSession().getAttribute(Const.currentUser);
            if (!user.getRole().equals(Const.ADMIN)){
                response.sendError(403, "Not Admin");
            }
        }
        return true;
    }
    }

