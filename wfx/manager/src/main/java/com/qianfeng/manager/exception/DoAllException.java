package com.qianfeng.manager.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DoAllException {
    @ExceptionHandler
    public String doException(Exception ex){
        return "/";
    }
}
