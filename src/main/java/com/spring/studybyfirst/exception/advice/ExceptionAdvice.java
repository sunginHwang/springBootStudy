package com.spring.studybyfirst.exception.advice;

import com.spring.studybyfirst.exception.exceptions.BoardNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@ControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(BoardNotFoundException.class)
    @ResponseBody ErrorResponse
    boardNotFoundException(HttpServletRequest req, BoardNotFoundException ex){
        log.info("error : boardNotFoundException , url : {}",req.getRequestURI().toString() );
        return new ErrorResponse(req.getRequestURI().toString(),"존재하는 계시글이 없습니다." ,ex);
    }
}
