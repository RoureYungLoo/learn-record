package com.xxx.structural.bridge_pattern.two;

/* 具体实现类 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("operationImpl A");
    }
}
