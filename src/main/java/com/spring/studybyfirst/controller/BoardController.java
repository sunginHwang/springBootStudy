package com.spring.studybyfirst.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "board")
public class BoardController {

    @GetMapping(value = "/test")
    @ApiOperation(value = "테스트용")
    public String boardTest(){
        return "Test";
    }


}
