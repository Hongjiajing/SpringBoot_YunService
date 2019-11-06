package com.baizhi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Component
public class ADDInterceptor extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginForce loginForce;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginForce).addPathPatterns("/User/**").excludePathPatterns("/User/login").excludePathPatterns("/User/regist");
    }
}
