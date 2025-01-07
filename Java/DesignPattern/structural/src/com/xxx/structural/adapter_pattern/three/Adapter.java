package com.xxx.structural.adapter_pattern.three;

/* 适配器类 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}
