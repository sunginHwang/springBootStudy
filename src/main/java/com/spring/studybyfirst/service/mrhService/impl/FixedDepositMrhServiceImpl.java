package com.spring.studybyfirst.service.mrhService.impl;

import com.spring.studybyfirst.service.mrhService.AbstructMrhService;
import org.springframework.stereotype.Service;

import java.util.concurrent.AbstractExecutorService;

@Service
public class FixedDepositMrhServiceImpl extends AbstructMrhService{
    @Override
    public int getPrice(int price) {
        return price;
    }


}
