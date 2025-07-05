package com.xxx.structural.proxy_pattern.static_proxy.by_implementation;

/* 真实主题, 被代理的对象 */
public class Tank implements Fireable {
    @Override
    public void fire() {
        System.out.println("士兵开炮了");
    }
}
