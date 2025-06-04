package com.randolflu.springframework03aop.aspect4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect2.class);

    /* 切点表达式 */
    @Pointcut("execution(* com.randolflu.springframework03aop.aspect4.*.*(..))")
    public void pointCut1() {
    }

    /*前置通知*/
//    @Before("pointCut1()")
    public void beforeAdvice(JoinPoint jp) {
        LOGGER.info("[aspectj] 前置通知");
        String kind = jp.getKind();
        Signature signature = jp.getSignature();
        Object target = jp.getTarget();
        Object aThis = jp.getThis();
//        System.out.println("kind "+kind);
//        System.out.println("signature.getName() "+signature.getName());
//        System.out.println("target "+target.getClass());
//        System.out.println("aThis "+aThis.getClass());
    }


    /*最终通知*/
//    @After("pointCut1()")
    public void afterAdvice(JoinPoint jp) {
        LOGGER.info("[aspectj] 最终通知");
    }

    /*返回通知*/
//    @AfterReturning(value = "pointCut1()", returning = "retValue")
    public void afterReturningAdvice(JoinPoint jp, Object retValue) {
        LOGGER.info("[aspectj] 返回通知, retValue: " + retValue);
    }

    /*异常通知*/
//    @AfterThrowing(value = "pointCut1()",throwing = "ex")
    public void afterThrowingAdvice(JoinPoint jp, Exception ex) {
        LOGGER.info("[aspectj] 异常通知, ex: " + ex.getMessage());
    }


    @Pointcut("execution(* get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* set*(..))")
    public void setter() {
    }

    /*环绕通知*/
//    @Around("execution(* com.randolflu.springframework03aop.aspect4.Order.get*(..))")
    @Around("getter() || setter()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        LOGGER.info("[aspectj] 环绕通知 前");

        Object retValue = pjp.proceed();
        LOGGER.info("[aspectj] 环绕通知, retValue: " + retValue);

        LOGGER.info("[aspectj] 环绕通知 后");

        retValue = new Order(666L, 666L, 666L).getId();

        return retValue;
    }

}
