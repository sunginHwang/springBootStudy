package com.spring.studybyfirst.boardTest;


import com.spring.studybyfirst.controller.BoardController;
import com.spring.studybyfirst.model.reactBoard.IBoard;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl.FirstOhBoardServiceImpl;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl.SecondOhBoardServiceImpl;
import junit.framework.Assert;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@Log4j2
@SpringBootTest
public class BoardControllerTest {

    @Autowired
    private BoardController boardController;

    @Autowired
    private FirstOhBoardServiceImpl firstOhBoardService;

    @Autowired
    private SecondOhBoardServiceImpl secondOhBoardService;


    @Value("${property.environment}")
    private String environment;


    @Test
    public void 테스트케이스시험(){
        String equalsValue = "Test";
        String value = "Test";
        Assert.assertEquals(equalsValue,value);
    }

    @Test
    public void 테스트실패케이스시험(){
        String equalsValue = "TestFail";
        String value = "Test";
        Assert.assertEquals(equalsValue,value);
    }

    @Test
    public void VO인터페이스테스트NonTitle(){
        try {
            List<IBoard> boards = secondOhBoardService.getBoardListTest();
            boards.stream().map(board -> {
                log.info("board Content Non title : {}",board.toString());
                return board;
            }).collect(Collectors.toList());

        }catch (Exception e){

        }
    }

    @Test
    public void VO인터페이스테스트NonContent(){
        try {
            List<IBoard> boards = firstOhBoardService.getBoardListTest();
            boards.stream().map(board -> {
                log.info("board Content non content: {}",board.toString());
                return board;
            }).collect(Collectors.toList());

        }catch (Exception e){

        }
    }

    @Test
    public void 로그테스트(){
        try {
            log.debug("log debug Test Access {}","HelloWorld");
            log.info("log info Test Access {}","HelloWorld");
            throw new Exception();
        }catch (Exception e){
            log.error("error region : {}",e.toString());
        }
    }

    @Test
    public void 커스텀프로퍼티라이브테스트(){
        Assert.assertEquals(environment, "live");
    }

    @Test
    public void 커스텀프로퍼티개발테스트(){
        Assert.assertEquals(environment, "dev");
    }

}
