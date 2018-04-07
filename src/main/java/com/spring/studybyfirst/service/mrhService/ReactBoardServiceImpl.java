package com.spring.studybyfirst.service.mrhService;

import com.spring.studybyfirst.model.reactBoard.OhBoard;
import com.spring.studybyfirst.repository.reactBoard.ReactBoardDbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactBoardServiceImpl {

    @Autowired
    ReactBoardDbMapper reactBoardDbMapper;

    public List<OhBoard> getBoardList() throws Exception {
        return reactBoardDbMapper.getBoardList();
    }

    public OhBoard getBoard(Integer boardKey) throws Exception {
        return reactBoardDbMapper.getBoard(boardKey);
    }
}
