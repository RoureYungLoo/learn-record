package com.xxx.structural.bridge_pattern.two;

public class Client {
    public static void main(String[] args) {
        Implementor implementorA = new ConcreteImplementorA();

        Abstraction abstraction = new RefinedAbstraction();

        abstraction.setImpl(implementorA);

        abstraction.operation();

    }
}
