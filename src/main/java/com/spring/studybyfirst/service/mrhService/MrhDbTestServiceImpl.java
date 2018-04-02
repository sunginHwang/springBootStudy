package com.spring.studybyfirst.service.mrhService;

import com.spring.studybyfirst.repository.mrh.MrhDbMapper;
import com.spring.studybyfirst.repository.reactBoard.ReactBoardDbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MrhDbTestServiceImpl {

    @Autowired
    MrhDbMapper mrhDbMapper;

    @Autowired
    ReactBoardDbMapper reactBoardDbMapper;

    public String dbTest() throws Exception {
        String Test = reactBoardDbMapper.now();
      return mrhDbMapper.now();
    }
}
