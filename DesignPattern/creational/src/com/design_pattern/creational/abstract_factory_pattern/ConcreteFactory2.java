package com.design_pattern.creational.abstract_factory_pattern;

public class ConcreteFactory2 implements Factory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}
