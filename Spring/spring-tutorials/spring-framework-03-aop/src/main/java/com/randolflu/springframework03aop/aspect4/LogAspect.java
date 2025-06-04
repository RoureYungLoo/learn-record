package com.randolflu.springframework03aop.aspect4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    /*前置通知*/
    public void beforeAdvice(JoinPoint jp) {
        LOGGER.info("[aspectj] 前置通知");
        String kind = jp.getKind();
        Signature signature = jp.getSignature();
        Object target = jp.getTarget();
        Object aThis = jp.getThis();
//        System.out.println("kind "+kind);
//        System.out.println("signature.getName() "+signature.getName());
        System.out.println("target "+target.getClass());
        System.out.println("aThis "+aThis.getClass());
    }


    /*最终通知*/
    public void afterAdvice(JoinPoint jp) {
        LOGGER.info("[aspectj] 最终通知");
    }

    /*返回通知*/
    public void afterReturningAdvice(JoinPoint jp, Object retValue) {
        LOGGER.info("[aspectj] 返回通知, retValue: " + retValue);
    }

    /*异常通知*/
    public void afterThrowingAdvice(JoinPoint jp, Exception ex) {
        LOGGER.info("[aspectj] 异常通知, ex: " + ex.getMessage());
    }

    /*环绕通知*/
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        LOGGER.info("[aspectj] 环绕通知 前");

        Object retValue = pjp.proceed();
        LOGGER.info("[aspectj] 环绕通知, retValue: " + retValue);

        LOGGER.info("[aspectj] 环绕通知 后");

//        retValue = 666L;

        return retValue;
    }

}
