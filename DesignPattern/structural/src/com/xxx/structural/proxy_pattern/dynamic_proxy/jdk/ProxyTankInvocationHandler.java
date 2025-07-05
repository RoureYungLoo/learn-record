package com.xxx.structural.proxy_pattern.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* 代理类 */
public class ProxyTankInvocationHandler implements InvocationHandler {

    /* 接口 */
    private final Fireable fireable;


    public ProxyTankInvocationHandler(Fireable fireable) {
        this.fireable = fireable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("-------- 正在记录操作日志 前 -----------");
        /* 调用接口的方法, 获得返回值 */
        Object returnValue = method.invoke(fireable, args);

        System.out.println("-------- 正在记录操作日志 后 -----------");

        return returnValue;
    }
}
