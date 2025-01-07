package com.example.springboot06.utils;

public class Result<Data> {
    private int code;
    private String msg;
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private Result() {
    }

    private Result(int code, String msg, Data data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result<Object> success() {
        return new Result<>(0, "success", null);
    }

    public static <Data> Result<Data> success(Data data) {
        return new Result<>(0, "success", data);
    }


    public static void failed() {
    }

    public static void error() {
    }
}
