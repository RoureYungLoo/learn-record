package com.xxx.structural.decorator_pattern.five;

/* 具体装饰器 A */
public class ConcreteDecoratorA extends Decorator {

  private Object addedState = "增加的状态";
  public ConcreteDecoratorA(ConcreteComponent component) {
    super(component);
  }

  @Override
  public void operation() {
    super.operation();
    System.out.println("增加的状态");
  }
}
