package com.xxx.structural.decorator_pattern.two;

/* 具体 装饰器 类 */
public class ConcreteDecoratorA extends Decorator {

  /* 装饰的状态 */
  private Object addedState;

  public ConcreteDecoratorA(Component component) {
    super(component);
  }

  @Override
  public void operation() {
    super.operation();
    addedBehavior();
  }

  /* 装饰的功能 */
  private void addedBehavior(){
    System.out.println("addedBehavior in A ");
  }
}
