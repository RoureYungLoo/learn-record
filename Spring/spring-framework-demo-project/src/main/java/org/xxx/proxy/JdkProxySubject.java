package org.xxx.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xxx.service.OrderService;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JdkProxySubject implements InvocationHandler {
    // private Subject subject;
    private OrderService subject;
    private Logger logger = LoggerFactory.getLogger(JdkProxySubject.class);

    public JdkProxySubject(OrderService subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("---- jdk 动态代理 前置通知 ----");
        Object result = null;

        try {
            result = method.invoke(subject, args);
        } catch (Exception e) {
            logger.info("---- ex: " + e.getMessage() + " ----");
            throw e;
        } finally {
            logger.info("---- jdk 动态代理 后置通知 ----");
        }
        return result;
    }
}
