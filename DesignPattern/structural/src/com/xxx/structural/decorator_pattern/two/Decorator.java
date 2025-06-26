package com.xxx.structural.decorator_pattern.two;

/* 装饰器类 */
public abstract class Decorator implements Component {
  /* 持有 抽象组件 引用 */
  private Component component;

  public Decorator(Component component) {
    this.component = component;
  }

  @Override
  public void operation() {
    /* 调用 抽象组件 的 业务方法, 装饰过程由子类完成 */
    component.operation();
  }
}
