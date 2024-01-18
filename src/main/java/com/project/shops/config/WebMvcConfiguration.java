package com.project.shops.config;

import com.project.shops.interceptor.LoginAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginAuthInterceptor loginAuthInterceptor;

//    @Autowired
//    private UserProperties userProperties;

    //拦截器注册
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthInterceptor)
                .excludePathPatterns("/api/v1/auth/login" ,
                        "/api/v1/auth/captcha","/api/v1/auth/verify_code")
                //.excludePathPatterns(userProperties.getNoAuthUrls())
                .addPathPatterns("/**");
    }

    //跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")      // 添加路径规则
                .allowCredentials(true)               // 是否允许在跨域的情况下传递Cookie
                //.allowedOriginPatterns("*")           // 允许请求来源的域规则
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*") ;
    }
}
