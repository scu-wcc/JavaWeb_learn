package org.example.exception;

import org.example.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result returnException(Exception ex){
        ex.printStackTrace();
        return Result.error("对不起，出错了，请联系管理员");
    }

}
