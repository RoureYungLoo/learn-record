package com.xxx.structural.decorator_pattern.three;

/* 抽象装饰器类 */
public abstract class ComponentDecorator extends Component {
  private Component component;

  public ComponentDecorator(Component component) {
    this.component = component;
  }

  @Override
  void display() {
    component.display();
  }
}
