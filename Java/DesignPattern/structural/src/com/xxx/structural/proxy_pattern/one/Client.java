package com.xxx.structural.proxy_pattern.one;

public class Client {
    public static void main(String[] args) {
        /* 真实对象, 被代理的类 */
        RealSubject realSubject = new RealSubject();

        /* 代理类*/
        Subject proxy = new Proxy(realSubject);

        /* 调用代理类的方法 */
        proxy.Request();
    }
}
