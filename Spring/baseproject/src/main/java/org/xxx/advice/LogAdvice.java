package org.xxx.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/* 使用spring 框架自带的aop */
public class LogAdvice implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {
    private Logger logger = LoggerFactory.getLogger(LogAdvice.class);


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info("---- 环绕通知-目标方法执行前 ---");

        invocation.proceed();

        logger.info("---- 环绕通知-目标方法执行后 ---");
        return null;
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        // 后置通知
        logger.info("-- 后置通知 --");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        // 前置通知
        logger.info("-- 前置通知 --");
    }
}
