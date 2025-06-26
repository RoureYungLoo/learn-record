package com.xxx.structural.decorator_pattern.five;

/* 抽象装饰器 */
public abstract class Decorator extends ConcreteComponent {
  private ConcreteComponent component;

  public Decorator(ConcreteComponent component) {
    this.component = component;
  }

  @Override
  public void operation() {
    component.operation();
  }
}
