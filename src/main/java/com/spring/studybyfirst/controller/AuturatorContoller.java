package com.spring.studybyfirst.controller;

import com.spring.studybyfirst.config.extra.HealthCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuturatorContoller {

    @Autowired
    private HealthCheck healthCheck;

    @GetMapping("/health")
    public Health auturatorInfo(){
        return healthCheck.health();
    }

    @GetMapping("/healthDown")
    public Health invoke(){
        return  healthCheck.healthDown();
    }
}
