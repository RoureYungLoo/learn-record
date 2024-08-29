package com.xxx.demo03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {


    @Pointcut("execution(* com.xxx.demo03..*.*(..))")
    private void myPointCut(){}

    @Before("myPointCut()")
    public void before(JoinPoint jp){
        System.out.println("前置..."+jp.getTarget());
        System.out.println("前置..."+jp.getSignature().getName());
    }

    @AfterReturning(value = "myPointCut()",returning = "ret")
    public void afterReturning(JoinPoint jp,Object ret){
        System.out.println("后置..."+ret);
    }

    @Around("myPointCut()")
    public void around(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("环绕前的通知");

        pjp.proceed();// 执行目标方法
        System.out.println("环绕后的通知");
    }

    @AfterThrowing(value = "myPointCut()",throwing = "ex")
    public void afterThrow(JoinPoint jp,Throwable ex){
        System.out.println("异常："+ex.getMessage());
    }

    @After("myPointCut()")
    public void after(){
        System.out.println("最终通知");
    }
}
