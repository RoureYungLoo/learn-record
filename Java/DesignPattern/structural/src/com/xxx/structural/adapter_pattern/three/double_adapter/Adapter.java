package com.xxx.structural.adapter_pattern.three.double_adapter;

/* 双向适配器 */
public class Adapter {
    private Adaptee adaptee;
    private Target target;

    public Adapter(Target target) {
        this.target = target;
    }

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }

    public void specificRequest() {
        target.request();
    }
}
