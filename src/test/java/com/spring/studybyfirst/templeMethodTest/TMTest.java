package com.spring.studybyfirst.templeMethodTest;

import com.spring.studybyfirst.controller.TMController;
import com.spring.studybyfirst.service.mrhService.impl.CustomCommonFunctionServiceImpl;
import com.spring.studybyfirst.service.mrhService.impl.FixedDepositMrhServiceImpl;
import com.spring.studybyfirst.service.mrhService.impl.SaveDepositMrhServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TMController.class, FixedDepositMrhServiceImpl.class, SaveDepositMrhServiceImpl.class, CustomCommonFunctionServiceImpl.class})
public class TMTest {

    private static final String COMMON_VALUE = "This function is common Function";
    private static final int PRICE = 1000;


    @Autowired
    TMController tmController;

    @Autowired
    CustomCommonFunctionServiceImpl customCommonFunctionService;

    @Autowired
    FixedDepositMrhServiceImpl fixedDepositMrhService;

    @Autowired
    SaveDepositMrhServiceImpl saveDepositMrhService;


    @Test
    public void 공통값테스트(){
        String commonValue = fixedDepositMrhService.commonFunction();
        Assert.assertEquals(commonValue, COMMON_VALUE);
    }

    @Test
    public void 다른값테스트(){
        int normalValue = fixedDepositMrhService.getPrice(PRICE);
        int doubleValue = saveDepositMrhService.getPrice(PRICE);
        Assert.assertEquals(doubleValue, normalValue * 2);
    }

    @Test
    public void 커스텀테스트(){
        String commonValue = fixedDepositMrhService.commonFunction();
        String customValue = customCommonFunctionService.commonFunction();
        Assert.assertEquals("Custom "+commonValue, customValue);
    }

}
