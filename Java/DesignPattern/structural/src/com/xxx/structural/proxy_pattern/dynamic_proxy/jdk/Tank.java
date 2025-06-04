package com.xxx.structural.proxy_pattern.dynamic_proxy.jdk;

/* 被代理的类 */
public class Tank implements Fireable {
    @Override
    public void fire() {
        System.out.println("士兵开炮了");
    }
}
