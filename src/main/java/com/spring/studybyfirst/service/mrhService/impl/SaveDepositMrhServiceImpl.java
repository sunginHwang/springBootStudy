package com.spring.studybyfirst.service.mrhService.impl;

import com.spring.studybyfirst.service.mrhService.AbstructMrhService;
import org.springframework.stereotype.Service;

@Service
public class SaveDepositMrhServiceImpl extends AbstructMrhService{

    @Override
    public int getPrice(int price) {
        return price*2;
    }
}
