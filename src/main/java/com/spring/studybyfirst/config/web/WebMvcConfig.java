package com.spring.studybyfirst.config.web;

import com.spring.studybyfirst.config.intercepter.LoggingIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@PropertySource({"classpath:/spring-${projectProfile}.properties"})
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingIntercepter());
        super.addInterceptors(registry);
    }
}
