package com.spring.studybyfirst.config.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class LoggingAOP {

    @Before("@annotation(com.spring.studybyfirst.config.annotation.CommonLog) || @within(com.spring.studybyfirst.config.annotation.CommonLog)")
    public void beforeLogging(JoinPoint joinPoint){
        log.info("start method : {}, {}",joinPoint.getTarget().getClass().getSimpleName(),joinPoint.getSignature());
    }

    @After("@annotation(com.spring.studybyfirst.config.annotation.CommonLog) || @within(com.spring.studybyfirst.config.annotation.CommonLog)")
    public void afterLogging(JoinPoint joinPoint){
        log.info("end method : {}, {}",joinPoint.getTarget().getClass().getSimpleName(),joinPoint.getSignature());
    }
}
