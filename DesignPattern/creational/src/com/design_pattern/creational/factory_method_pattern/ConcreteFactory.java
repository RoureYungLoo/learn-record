package com.design_pattern.creational.factory_method_pattern;

/* 具体工厂 */
public class ConcreteFactory extends Factory {
    @Override
    public Product getProduct() {
        return new ConcreteProduct();
    }
}
