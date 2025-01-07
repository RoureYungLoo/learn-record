package com.xxx.structural.adapter_pattern.three.double_adapter;

public class ConcreteAdaptee implements Adaptee {
    @Override
    public void specificRequest() {
        System.out.println("被适配的接口");
    }
}
