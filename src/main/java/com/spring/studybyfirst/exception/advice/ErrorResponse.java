package com.spring.studybyfirst.exception.advice;

import lombok.Data;

@Data
public class ErrorResponse {

    private final String message;
    private final String errorMessage;
    private final String url;


    public ErrorResponse(String url, String message, Exception ex) {
        this.url = url;
        this.message = message;
        this.errorMessage = ex.getLocalizedMessage();
    }

    public ErrorResponse(String url, String message) {
        this.url = url;
        this.errorMessage = "";
        this.message = message;
    }

    public ErrorResponse(String url, Exception ex) {
        this.url = url;
        this.message = "";
        this.errorMessage = ex.getLocalizedMessage();
    }
}
