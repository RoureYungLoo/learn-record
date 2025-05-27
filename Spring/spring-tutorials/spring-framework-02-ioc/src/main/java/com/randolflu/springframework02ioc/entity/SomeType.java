package com.randolflu.springframework02ioc.entity;

public class SomeType {
    public void initMethod() {
        System.out.println("----- SomeType init ------");
    }

    public void destroyedMethod() {
        System.out.println("----- SomeType destroyed ------");
    }

}
