package com.xxx.structural.proxy_pattern.dynamic_proxy.jdk;


import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        /* 被代理的对象, 真实对象, 目标对象 */
        Tank tank = new Tank();

        ProxyTankInvocationHandler handler = new ProxyTankInvocationHandler(tank);

        Fireable fireable = (Fireable) Proxy.newProxyInstance(
                Tank.class.getClassLoader(),
                new Class[]{Fireable.class},
                handler
        );

        fireable.fire();

    }
}
