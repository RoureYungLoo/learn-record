package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.time.LocalDateTime;

@Aspect
public class LoggingWithAnnotation {

    @Pointcut("execution(* org.example.domain.Student.getName(..))")
    public void getName(){}

    @Pointcut("execution(* org.example.domain.Student.throwAnException(..))")
    public void throwAnException(){}

    @Before("getName()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("before advice " + LocalDateTime.now());
    }

    @After("getName()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("after advice " + LocalDateTime.now());
    }

    @AfterReturning(value = "getName()",returning = "retVal")
    public void afterReturnAdvice(JoinPoint joinPoint, Object retVal) {
        System.out.println("after return advice " + LocalDateTime.now()+" retVal: "+retVal);
    }

    @AfterThrowing(value = "throwAnException()",throwing = "ex")
    public void afterThrowingAdvice(Exception ex) {
        System.out.println("after throwing advice " + LocalDateTime.now() + ex.getMessage());
    }

    @Around(value = "getName()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around advice [before]" + LocalDateTime.now());
        Object retVal = null;
        try {
            retVal = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("around [???] "+e.getMessage());
            e.printStackTrace();
            throw e;
        }
        System.out.println("around advice [after]" + LocalDateTime.now() + " " + retVal);
        return retVal;
    }
}
