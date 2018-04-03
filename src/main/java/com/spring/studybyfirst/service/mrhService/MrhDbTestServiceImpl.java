package com.spring.studybyfirst.service.mrhService;

import com.spring.studybyfirst.repository.mrh.MrhDbMapper;
import com.spring.studybyfirst.repository.reactBoard.ReactBoardDbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MrhDbTestServiceImpl {

    @Autowired
    MrhDbMapper mrhDbMapper;

    @Autowired
    ReactBoardDbMapper reactBoardDbMapper;

    @Value("${spring.react.datasource.url}")
    private String url;


    public String dbTest() throws Exception {
        System.out.println(url);
        System.out.println(reactBoardDbMapper.now());
      return mrhDbMapper.now();
    }
}
