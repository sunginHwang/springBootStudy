package com.spring.studybyfirst.config.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommonLog {
    String value() default "test";
}
