package com.design_pattern.creational.abstract_factory_pattern;

public class ConcreteFactory1 implements Factory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1() ;
    }
}
