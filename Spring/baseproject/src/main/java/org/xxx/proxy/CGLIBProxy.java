package org.xxx.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {

    // 被代理的对象
    private Object target;

    private Logger logger = LoggerFactory.getLogger(CGLIBProxy.class);

    public CGLIBProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o/* 代理类对象 */, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        logger.info(" ---- CGLIB动态代理 前置通知 ----");

        // 调用目标方法，即被代理类的方法   // 调用原始对象
        Object result = methodProxy.invoke(target, args);

        // 调用代理类 此处o为代理类  // 调用增强后的对象
//        methodProxy.invokeSuper(o,args);

        logger.info(" ---- CGLIB动态代理 后置通知 ----");
        return result;
    }
}
