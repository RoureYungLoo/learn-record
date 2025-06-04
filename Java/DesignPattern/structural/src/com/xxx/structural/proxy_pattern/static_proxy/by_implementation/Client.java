package com.xxx.structural.proxy_pattern.static_proxy.by_implementation;

public class Client {
    public static void main(String[] args) {
        Tank tank = new Tank();

        ProxyTank proxyTank = new ProxyTank();

        proxyTank.setTank(tank);

        proxyTank.fire();
    }
}
