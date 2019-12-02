package com.lei.airlinereservation.common;

import com.lei.airlinereservation.interceptor.AdminInterceptor;
import com.lei.airlinereservation.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).order(Ordered.HIGHEST_PRECEDENCE);
        registry.addInterceptor(new AdminInterceptor()).order(Ordered.HIGHEST_PRECEDENCE + 1);
    }
}
