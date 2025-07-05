package com.xxx.structural.proxy_pattern.static_proxy.by_extends;

/* 代理类 */
public class ProxyTank extends Tank {
    private void preFire() {
        System.out.println("正在瞄准...");
    }

    private void postFire() {
        System.out.println("炮筒在冒烟...");
    }

    @Override
    public void fire() {
        preFire();

        super.fire();

        postFire();
    }
}
