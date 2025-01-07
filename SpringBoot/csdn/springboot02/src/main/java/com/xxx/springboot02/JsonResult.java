package com.xxx.springboot02;

import org.springframework.http.HttpStatus;

public class JsonResult<Data> {
    private Integer code;
    private String message;
    private Data data;

    public JsonResult() {
        code= HttpStatus.OK.value();
        message="success";
    }

    public JsonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(Data data) {
        this.code=200;
        this.message="success";
        this.data = data;
    }

    public JsonResult(String message, Data data) {
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
