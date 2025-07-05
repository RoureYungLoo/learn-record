package com.xxx.structural.proxy_pattern.static_proxy.by_implementation;

import java.util.logging.Logger;

/* 代理主题, 代理类 */
public class ProxyTank implements Fireable {
    private Tank tank;

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public ProxyTank() {
        tank = new Tank();
    }

    public ProxyTank(Tank tank) {
        this.tank = tank;
    }

    private void preFire() {
        System.out.println("----- 记录日志  操作前 ------");
    }

    private void postFire() {
        System.out.println("----- 记录日志  操作后 ------");
    }

    @Override
    public void fire() {
        preFire();

        tank.fire();

        postFire();
    }
}
