package com.xxx.structural.proxy_pattern.one;

/* 真实主题角色 */
public class RealSubject extends Subject {
    @Override
    public void Request() {
        System.out.println(" 真实主题：request()");
    }
}
