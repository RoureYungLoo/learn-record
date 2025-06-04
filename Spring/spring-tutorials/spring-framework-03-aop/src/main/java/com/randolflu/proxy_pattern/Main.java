package com.randolflu.proxy_pattern;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //真实主题 realsubject
        Hello original = new HelloImpl(); // 多态
        Hello helloProxy = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                original.getClass().getInterfaces(),
                new JdkHandler(original)
        );

        System.out.println(helloProxy.getClass().getName());

        // target是代理类对象
        helloProxy.say();

    }
}
