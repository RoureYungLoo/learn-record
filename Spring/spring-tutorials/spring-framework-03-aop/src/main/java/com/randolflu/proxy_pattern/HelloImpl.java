package com.randolflu.proxy_pattern;

// 实现类 真实主题 realsubject 被代理的对象
public class HelloImpl implements Hello {
    @Override
    public void say() {
        System.out.println("hello spring aop");
    }
}
