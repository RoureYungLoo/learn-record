package com.example.rocketmq.util;

import org.springframework.http.HttpStatus;

public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result(HttpStatus.OK.value(), "success", data);
    }
}
