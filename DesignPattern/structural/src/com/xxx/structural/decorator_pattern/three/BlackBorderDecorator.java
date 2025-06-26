package com.xxx.structural.decorator_pattern.three;

/* 具体装饰器类 */
public class BlackBorderDecorator extends ComponentDecorator {
  public BlackBorderDecorator(Component component) {
    super(component);
  }

  @Override
  void display() {
    setBlackBorder();
    super.display();
  }

  /* 新增加的功能 */
  public void setBlackBorder() {
    System.out.println("set blockBorder");
  }
}
