package com.design_pattern.creational.factory_method_pattern;

/* 具体产品 */
public class ConcreteProduct extends Product{
    @Override
    void show() {
        System.out.println("ConcreteProduct show");
    }
}
