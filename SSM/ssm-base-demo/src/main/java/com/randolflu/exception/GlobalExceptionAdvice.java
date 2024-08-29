package com.randolflu.exception;

import com.randolflu.controller.Code;
import com.randolflu.controller.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    /* 处理系统异常 */
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        // 1. 记录日志
        // 2. 发送消息给运维
        // 3. 发送邮件给开发人员, ex对象发送给开发人员
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    /* 处理业务异常 */
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex) {
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    /* 处理其他异常 */
    @ExceptionHandler(Exception.class)
    public Result doException2(Exception ex) {
        // 1. 记录日志
        // 2. 发送消息给运维
        // 3. 发送邮件给开发人员, ex对象

        System.out.println("出错了:" + ex.getMessage());
        return new Result(Code.OTHER_ERR, null, "系统繁忙!");
    }

//    @ExceptionHandler(Exception.class)
//    public void doException(Exception ex) {
//        System.out.println("出错了:" + ex.getMessage());
//    }
}