package com.xxx.structural.decorator_pattern.five;

public class Client {
  public static void main(String[] args) {
    ConcreteComponent component,componentDecoratorA,concreteComponentB;

    component = new ConcreteComponent();

    componentDecoratorA = new ConcreteDecoratorA(component);

    componentDecoratorA.operation();

    concreteComponentB = new ConcreteDecoratorB(componentDecoratorA);

    concreteComponentB.operation();

  }
}
