package org.xxx.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 使用aspectj */
public class LogAdvice2 {
    private Logger logger = LoggerFactory.getLogger(LogAdvice2.class);

    // 前置通知
    public void beforeAdvice(JoinPoint joinpoint) {
        logger.info("---- [aspectj] 前置通知 ----");
    }

    // 后置通知
    public void afterReturningAdvice(JoinPoint joinpoint, Object returnVal) {
        logger.info("---- [aspectj] 后置通知 ----");
    }

    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("---- [aspectj] 后置通知 ----");
    }

    // 环绕通知
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("---- [aspectj] 环绕通知 前 ----");
        Object returnValue = joinPoint.proceed();
        logger.info("---- [aspectj] 环绕通知 后 ----");
        return returnValue;
    }

    // 异常通知
    public void throwAdvice(JoinPoint joinPoint, Exception exception) {
        logger.info("---- [aspectj] 异常通知 e: " + exception.getMessage() + " ----");
    }
}
