package com.xxx.structural.decorator_pattern.one;

public class ScrollBarBlackBorderWindow {
  private ScrollBarWindow scrollBarWindow;
  private BlackBorderWindow blackBorderWindow;

  public ScrollBarBlackBorderWindow() {
    this.scrollBarWindow = new ScrollBarWindow();
    this.blackBorderWindow = new BlackBorderWindow();
  }
  void display(){
    scrollBarWindow.setScrollBar();
    blackBorderWindow.setBlackBorder();
    System.out.println("show ScrollBar BlackBorder Window");
  }
}
