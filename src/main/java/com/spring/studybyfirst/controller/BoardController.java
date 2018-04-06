package com.spring.studybyfirst.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "board")
public class BoardController {

    @GetMapping(value = "/test")
    @ApiOperation(value = "테스트용")
    public String boardTest(){
        return "Test";
    }


    @GetMapping(value = "/logTest")
    @ApiOperation(value = "로그테스트용")
    public String log4jTest(){

        try {
            log.debug("log debug Test Access {}","HelloWorld");
            log.info("log info Test Access {}","HelloWorld");
            throw new Exception();
        }catch (Exception e){
            log.error("error region : {}",e.toString());
        }
        return "success";
    }

}
