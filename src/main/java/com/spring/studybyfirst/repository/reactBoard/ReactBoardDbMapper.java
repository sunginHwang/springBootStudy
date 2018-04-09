package com.spring.studybyfirst.repository.reactBoard;

import com.spring.studybyfirst.model.reactBoard.IBoard;
import com.spring.studybyfirst.model.reactBoard.OhBoard;

import java.util.List;

public interface ReactBoardDbMapper {
    public String now() throws Exception;
    public List<OhBoard> getBoardList() throws Exception;
    public OhBoard getBoard(int boardKey) throws Exception;
    public List<IBoard> getIBoardListNotContent() throws Exception;
    public List<IBoard> getIBoardListNotTitle() throws Exception;
}
