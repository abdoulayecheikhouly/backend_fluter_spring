package com.sn.dev.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ArticleNotFoundException extends RuntimeException{

    public ArticleNotFoundException(String message) {
        super(message);
    }
    public ArticleNotFoundException(String message,Throwable cause) {
        super(message,cause);
    }
}
