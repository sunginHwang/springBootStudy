package com.spring.studybyfirst.service.mrhService;

public abstract class AbstructMrhService implements MrhService {
    @Override
    public String commonFunction() {
        return "This function is common Function";
    }
}
