package com.xxx.demo02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect02 {

    @Before("execution(public void com.xxx.demo02.UserService.*())")
    public void before02(){
        System.out.println("开启事务");
    }

    @After("execution(public void com.xxx.demo02.UserService.*())")
    public void after02(){
        System.out.println("关闭事务");
    }
}
