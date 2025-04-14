package org.xxx.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice3 {
    private Logger logger = LoggerFactory.getLogger(LogAdvice3.class);

    //    private final String pointcut = "execution(* org.xxx.service.impl.*.*(..))";
    @Pointcut(value = "execution(* org.xxx.service.impl.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("---- @Before ----");
    }

    @After("pointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("---- @After ----");

    }

    @AfterReturning(value = "pointcut()", returning = "returnVal")
    public void afterReturningAdvice(JoinPoint joinPoint, Object returnVal) {
        logger.info("---- @AfterReturning ----");
//        logger.info("---- 返回后通知 返回值：" + returnVal + " ----");

    }

    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("---- @Around 前 ----");
        Object resultValue = joinPoint.proceed();
        logger.info("---- @Around 后 ----");
        return resultValue;
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void throwAdvice(JoinPoint joinPoint, Exception ex) {
        logger.info("---- @AfterThrowing ex: " + ex.getMessage() + "----");
    }
}
