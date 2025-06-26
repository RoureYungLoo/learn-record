package com.xxx.structural.decorator_pattern.five;

/* 具体装饰器 B */
public class ConcreteDecoratorB extends Decorator {
  public ConcreteDecoratorB(ConcreteComponent component) {
    super(component);
  }

  @Override
  public void operation() {
    super.operation();
    addedBehavior();
  }

  public void addedBehavior() {
    System.out.println("增加的行为");
  }
}
