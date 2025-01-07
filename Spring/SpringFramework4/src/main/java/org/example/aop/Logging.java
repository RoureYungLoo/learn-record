package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDateTime;


public class Logging {
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("before advice " + LocalDateTime.now());
    }

    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("after advice " + LocalDateTime.now());
    }

    public void afterReturnAdvice(JoinPoint joinPoint, Object retVal) {
        System.out.println("after return advice " + LocalDateTime.now()+" retVal: "+retVal);
    }

    public void afterThrowingAdvice(Exception ex) {
        System.out.println("after throwing advice " + LocalDateTime.now() + ex.getMessage());
    }

    public Object aroundAdvice(ProceedingJoinPoint joinPoint, Object retVal) throws Throwable {
        System.out.println("around advice [before]" + LocalDateTime.now());
        retVal = joinPoint.proceed();
        System.out.println("around advice [after]" + LocalDateTime.now() + " " + retVal);
        return retVal;
    }
}
