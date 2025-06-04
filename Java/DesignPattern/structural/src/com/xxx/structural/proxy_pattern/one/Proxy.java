package com.xxx.structural.proxy_pattern.one;

/* 代理主题角色, 代理类 */
public class Proxy extends Subject {

    private RealSubject realSubject;

    public Proxy() {
    }

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void Request() {
        PreRequest();

        realSubject.Request(); // 调用真实主题对象的方法

        PostRequest();
    }

    public void PostRequest() {
        System.out.println(" --- [代理类] postRequest() ----");
    }

    public void PreRequest() {
        System.out.println(" --- [代理类] preRequest ----");
    }
}
