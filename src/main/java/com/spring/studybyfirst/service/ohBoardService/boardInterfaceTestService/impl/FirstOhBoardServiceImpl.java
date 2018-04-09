package com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl;

import com.spring.studybyfirst.model.reactBoard.IBoard;
import com.spring.studybyfirst.repository.reactBoard.ReactBoardDbMapper;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.OhBoardServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstOhBoardServiceImpl implements OhBoardServiceTest{

    @Autowired
    ReactBoardDbMapper reactBoardDbMapper;

    @Override
    public List<IBoard> getBoardListTest() throws Exception {
        return reactBoardDbMapper.getIBoardListNotContent();
    }
}
