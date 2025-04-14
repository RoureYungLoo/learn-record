package com.xxx.nacosproviderpayment9001.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pay")
public class PayController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/{id}")
    public Result getPayInfo(@PathVariable("id") Integer id){
        return Result.success("nacos registry, serverPort: "+serverPort+"\t id: "+id);
    }
}

class Result<T>{
    private Integer code;
    private String msg;
    private T data;


    private Result() {
    }

    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(){
        return new Result<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public static <T> Result<T> success(T data){
        return new Result<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),data);
    }

    public void failed(){

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}