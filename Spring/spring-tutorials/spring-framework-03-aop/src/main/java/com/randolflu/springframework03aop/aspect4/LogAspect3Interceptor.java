package com.randolflu.springframework03aop.aspect4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterAdvice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.cglib.proxy.MethodProxy;

import javax.servlet.ServletException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

public class LogAspect3Interceptor
        implements
        MethodInterceptor,
        MethodBeforeAdvice,
        AfterReturningAdvice {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect3Interceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info("[aop api] 环绕通知 前");
        Object retValue = invocation.proceed();
        logger.info("[aop api] 环绕通知 业务方法返回值: " + retValue);
        logger.info("[aop api] 环绕通知 后");
        return retValue;
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
//        returnValue = method.invoke(target, args);
        logger.info("afterReturning 通知");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
//        method.invoke(target, args);
        logger.info("before 前置通知");

    }



//    public void afterThrowing(Method m, Object[] args, Object target, ServletException ex) {
//        // Do something with all arguments
//        logger.info("异常通知: " + ex.getMessage());
//        System.out.println(m.getClass().getName());
//        System.out.println(target.getClass().getName());
//        System.out.println(ex.getMessage());
//    }


}
