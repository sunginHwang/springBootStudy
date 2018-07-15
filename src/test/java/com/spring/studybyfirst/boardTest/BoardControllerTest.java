package com.spring.studybyfirst.boardTest;


import com.spring.studybyfirst.common.util.DataUtil;
import com.spring.studybyfirst.controller.BoardController;
import com.spring.studybyfirst.model.reactBoard.IBoard;
import com.spring.studybyfirst.model.reactBoard.OhBoard;
import com.spring.studybyfirst.model.vo.NpeTestVO;
import com.spring.studybyfirst.service.mrhService.ReactBoardServiceImpl;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl.FirstOhBoardServiceImpl;
import com.spring.studybyfirst.service.ohBoardService.boardInterfaceTestService.impl.SecondOhBoardServiceImpl;
import junit.framework.Assert;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@TestPropertySource(properties = {"projectProfile=dev"})
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

    @Autowired
    private ReactBoardServiceImpl reactBoardService;


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
    public void Stream에서의객체키값중복제거테스트(){
        Integer boardKey = 1;
        List<OhBoard> boards = new ArrayList<>();
        try {
            OhBoard masterBoard = reactBoardService.getBoard(boardKey);
            OhBoard DuplicateBoard = reactBoardService.getBoard(boardKey);

            if(masterBoard != null && DuplicateBoard != null){
                boards.add(masterBoard);
                boards.add(DuplicateBoard);
            }

            if(boards.size() >0){
                Assert.assertEquals(boards.size(),2);
                System.out.println(boards.toString());
                //객체 중복 제거
                boards = boards.stream().collect(DataUtil.distinctByKey(OhBoard::getBoardKey)).collect(Collectors.toList());
                System.out.println(boards.toString());
                Assert.assertEquals(boards.size(),1);
            }

        }catch (Exception e){
            log.info(e);
        }


    }

    @Test
    public void npe테스트(){
        NpeTestVO npeTestVO = new NpeTestVO();
        npeTestVO.setId("");
        npeTestVO.setTitle("12");

        try {
            String propertyId = Optional.ofNullable(npeTestVO.getId())
                                        .filter(id->!id.isEmpty())
                                        .orElseThrow(IllegalAccessException::new);
            System.out.println(propertyId);
        } catch (IllegalAccessException e) {
            log.info("log error :{}",DataUtil.toJson(npeTestVO));
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
