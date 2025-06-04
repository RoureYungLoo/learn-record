package com.randolflu.proxy_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* InvocationHandler 实现类 */
public class JdkHandler implements InvocationHandler {

    // 接口 抽象主题 subject
    private Hello hello;

    public JdkHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy.getClass().getName());
        System.out.println(hello.getClass().getName());
        System.out.println("调用业务方法前");

        Object retValue = method.invoke(hello, args);

        System.out.println("调用业务方法后");

        return retValue;
    }
}
