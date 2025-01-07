package com.xxx.structural.adapter_pattern.three.double_adapter;

public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("目标接口");
    }
}
