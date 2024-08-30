package com.randolflu.exception;

import com.randolflu.constants.Code;
import com.randolflu.constants.Msg;
import com.randolflu.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(Code.OPTION_FAILED, e.getMessage());
    }
}
