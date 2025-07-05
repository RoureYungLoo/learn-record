package com.xxx.structural.adapter_pattern.one;

/* 适配器类，别名 Wrapper类 */
public class Adapter extends Target {
    private Adaptee adaptee; // 被适配的类

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
