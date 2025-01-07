package com.randolflu.pojo;

import com.randolflu.constants.Code;
import com.randolflu.constants.Msg;

public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String success) {
        this.code = code;
        this.msg = success;
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

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /* 操作成功，携带数据 */
    public static <E> Result<E> success(Integer code, String msg, E data) {
        return new Result(code, msg, data);
    }

    /* 操作成功，无数据 */
    public static Result success(Integer code, String msg) {
        return new Result(code, msg, null);
    }

    public static Result success() {
        return new Result(0, "success");
    }

    public static Result success(String msg) {
        return new Result(0, msg);
    }

    public static <E> Result<E> success(E data) {
        return new Result(0, "success", data);
    }

    /* 操作失败 */
    public static Result error(Integer errCode, String errMsg) {
        return new Result(errCode, errMsg, null);
    }

    public static Result error() {
        return new Result(1, "failed");
    }

    public static Result error(String msg) {
        return new Result(1, msg);
    }
}
