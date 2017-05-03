package com.example.common.interceptor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhangzhizhong on 2017/4/19.
 */
@Configuration
@ComponentScan(basePackages = "com.example.*")
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册监控拦截器
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**");

    }


}
