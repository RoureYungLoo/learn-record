package com.xxx.structural.proxy_pattern.static_proxy.by_extends;

public class Client {
    public static void main(String[] args) {

        /* 通过继承实现的代理 */
        ProxyTank proxyTank = new ProxyTank();
        proxyTank.fire();

        /* 通过组合实现的代理 */
//        ProxyTank2 proxyTank2 = new ProxyTank2();
//        proxyTank2.setLogger(MyLogger.getLogger());
//        proxyTank2.setTank(new Tank2());

//        proxyTank2.fire();
    }
}
