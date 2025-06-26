package com.xxx.structural.decorator_pattern.three;

/* 具体装饰器类 */
public class ScrollBarDecorator extends ComponentDecorator {

  public ScrollBarDecorator(Component component) {
    super(component);
  }

  @Override
  void display() {
    setScrollBar();
    super.display();
  }

  /* 新增加的功能 */
  public void setScrollBar() {
    System.out.println("set scrollBar");
  }
}
