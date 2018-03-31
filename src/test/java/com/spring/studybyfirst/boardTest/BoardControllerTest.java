package com.spring.studybyfirst.boardTest;


import com.spring.studybyfirst.controller.BoardController;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BoardController.class)
public class BoardControllerTest {

    @Autowired
    BoardController boardController;

    @Test
    public void 테스트케이스시험(){
        String equalsValue = "Test";
        String boardTestValue = boardController.boardTest();
        Assert.assertEquals(equalsValue,boardTestValue);
    }

    @Test
    public void 테스트실패케이스시험(){
        String equalsValue = "TestFail";
        String boardTestValue = boardController.boardTest();
        Assert.assertEquals(equalsValue,boardTestValue);
    }

}
