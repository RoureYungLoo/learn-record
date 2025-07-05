package com.xxx.structural.proxy_pattern.dynamic_proxy.cglib;

/* 真实对象, 被代理类, 目标对象 */
public class Tank {
    private String nation="中国";
    public String fire(int num,String category) {
        System.out.printf("%s坦克发射了 %d 枚 %s\n",nation,num,category);
        return "发射成功";
    }
}
