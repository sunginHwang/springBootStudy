package com.spring.studybyfirst.controller;

import com.spring.studybyfirst.service.mrhService.impl.CustomCommonFunctionServiceImpl;
import com.spring.studybyfirst.service.mrhService.impl.FixedDepositMrhServiceImpl;
import com.spring.studybyfirst.service.mrhService.impl.SaveDepositMrhServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "tm")
public class TMController {

    @Autowired
    FixedDepositMrhServiceImpl fixedDepositMrhService;

    @Autowired
    SaveDepositMrhServiceImpl saveDepositMrhService;

    @Autowired
    CustomCommonFunctionServiceImpl customCommonFunctionService;

    final static int PRICE = 1000;

    @GetMapping(value = "/common")
    public String commonFunctionTest(){
        return fixedDepositMrhService.commonFunction();
    }

    @GetMapping(value = "/fixedValue")
    public int getFixedValue(){
        return fixedDepositMrhService.getPrice(PRICE);
    }

    @GetMapping(value = "/saveValue")
    public int getSaveValue(){
        return saveDepositMrhService.getPrice(PRICE);
    }

    @GetMapping(value = "/custom/common")
    public String customCommonFunctionTest(){
        return customCommonFunctionService.commonFunction();
    }
}
