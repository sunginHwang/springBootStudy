package com.spring.studybyfirst.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "board")
public class BoardController {

    @GetMapping(value = "/test")
    public String boardTest(){
        return "Test";
    }


}
