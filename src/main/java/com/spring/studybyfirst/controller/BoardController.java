package com.spring.studybyfirst.controller;

import com.google.gson.reflect.TypeToken;
import com.spring.studybyfirst.common.util.DataUtil;
import com.spring.studybyfirst.config.annotation.CommonLog;
import com.spring.studybyfirst.model.reactBoard.IBoard;
import com.spring.studybyfirst.model.reactBoard.OhBoard;
import com.spring.studybyfirst.service.mrhService.ReactBoardServiceImpl;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl.FirstOhBoardServiceImpl;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl.SecondOhBoardServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@CommonLog
@RestController
@RequestMapping(value = "board")
public class BoardController {

    @Autowired
    ReactBoardServiceImpl reactBoardService;

    @Autowired
    FirstOhBoardServiceImpl firstOhBoardService;

    @Autowired
    SecondOhBoardServiceImpl secondOhBoardService;


    @GetMapping(value = "/test")
    @ApiOperation(value = "테스트용")
    public String boardTest(){
        return "Test";
    }

    @GetMapping(value = "/getBoard")
    @ApiOperation(value = "게시판 리스트")
    public List<OhBoard> getBoardList(){
        try {
            List<OhBoard> boardList = reactBoardService.getBoardList();
            return boardList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/getBoardJson")
    @ApiOperation(value = "게시판 리스트")
    public List<OhBoard> getBoardListForJson(){
        try {
            List<OhBoard> boardList = reactBoardService.getBoardList();
            String jsonBoardList = DataUtil.toJson(boardList);
            List<OhBoard> parseBoardList = DataUtil.fromJsonList(jsonBoardList,new TypeToken<List<OhBoard>>(){});
            parseBoardList.stream().map(k -> {k.setContent("non");return k;}).collect(Collectors.toList());
            return parseBoardList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/getBoardByBoardKey")
    @ApiOperation(value = "게시글")
    public OhBoard getBoard(@RequestParam Integer boardKey){
        try {
            OhBoard board = reactBoardService.getBoard(boardKey);
            return board;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    @GetMapping(value = "/boards/nontitle")
    @ApiOperation(value = "VO 인터페이스 테스트 NonTitle")
    public List<IBoard> getBoardListNotTitle() throws Exception {

      return secondOhBoardService.getBoardListTest();
    }

    @GetMapping(value = "/boards/nonContent")
    @ApiOperation(value = "VO 인터페이스 테스트 NonContent")
    public List<IBoard> getBoardListNotContent() throws Exception {

        return firstOhBoardService.getBoardListTest();
    }

}
