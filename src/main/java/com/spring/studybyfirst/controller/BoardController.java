package com.spring.studybyfirst.controller;

import com.google.gson.reflect.TypeToken;
import com.spring.studybyfirst.common.util.DataUtil;
import com.spring.studybyfirst.config.annotation.CommonLog;
import com.spring.studybyfirst.exception.exceptions.BoardNotFoundException;
import com.spring.studybyfirst.model.reactBoard.IBoard;
import com.spring.studybyfirst.model.reactBoard.OhBoard;
import com.spring.studybyfirst.service.mrhService.ReactBoardServiceImpl;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl.FirstOhBoardServiceImpl;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl.SecondOhBoardServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@CommonLog
@RestController
@RequestMapping(value = "blog")
public class BoardController {

    @Autowired
    ReactBoardServiceImpl reactBoardService;

    @Autowired
    FirstOhBoardServiceImpl firstOhBoardService;

    @Autowired
    SecondOhBoardServiceImpl secondOhBoardService;



    @GetMapping(value = "/boards")
    @ApiOperation(value = "게시판 리스트")
    public List<OhBoard> getBoardList(){
        try {
            List<OhBoard> boardList = reactBoardService.getBoardList();
            return boardList;
        } catch (Exception e) {
            log.info("boardList error ");
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/boards/NonContent")
    @ApiOperation(value = "게시판 리스트")
    public List<OhBoard> getBoardListNonContent(){
        try {
            List<OhBoard> boardList = reactBoardService.getBoardList();
            boardList.stream()
                     .map(k -> {k.setContent("");return k;})
                     .collect(Collectors.toList());

            return boardList;
        } catch (Exception e) {
            log.info("boardList nonContent error ");
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping(value = "/board/{boardKey}")
    @ApiOperation(value = "게시글")
    public OhBoard getBoard(@PathVariable Integer boardKey) throws Exception {

        OhBoard board = reactBoardService.getBoard(boardKey);

        if(ObjectUtils.isEmpty(board)){
            log.info("board not found , boardKey : {}",boardKey);
            throw new BoardNotFoundException("fe");
        }

        log.info("board Info : {}",board.toString());

        return board;
    }

}
