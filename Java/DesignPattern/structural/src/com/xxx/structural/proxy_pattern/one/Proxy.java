package com.xxx.structural.proxy_pattern.one;

/* 代理主题角色 */
public class Proxy extends Subject {

    private RealSubject realSubject = new RealSubject();

    public void PreRequest() {
        System.out.println(" --- pre request ----");
    }

    @Override
    public void Request() {
        PreRequest();

        realSubject.Request(); // 调用真实主题对象的方法

        PostRequest();
    }

    public void PostRequest() {
        System.out.println(" --- post request ----");
    }
}
