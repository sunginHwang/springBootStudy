package com.spring.studybyfirst.exception.exceptions;


public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardNotFoundException(String message) {
        super(message);
    }
}
