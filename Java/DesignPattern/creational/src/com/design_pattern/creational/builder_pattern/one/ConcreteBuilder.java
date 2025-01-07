package com.design_pattern.creational.builder_pattern.one;

public class ConcreteBuilder extends Builder {
    @Override
    void buildPartA() {
        System.out.println(" build part A");
    }

    @Override
    void buildPartB() {
        System.out.println(" build part B");

    }

    @Override
    void buildPartC() {
        System.out.println(" build part C");

    }
}
