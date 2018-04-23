package com.spring.studybyfirst.config.extra;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().build();
    }

    public Health healthDown() {
        return Health.down().build();
    }
}
