package com.xxx.structural.decorator_pattern.two;

/* 具体 装饰器 B */
public class ConcreteDecoratorB extends Decorator {
  private Object addedState;
  public ConcreteDecoratorB(Component component) {
    super(component);
  }

  @Override
  public void operation() {
    addedBehavior();
    super.operation();
  }

  private void addedBehavior(){
    System.out.println("addedBehavior in B");
  }
}
