package com.xxx.structural.decorator_pattern.one;

public class ScrollBarBlackBorderTextBox {
  private ScrollBarTextBox scrollBarTextBox;
  private BlackBorderTextBox blackBorderTextBox;

  public ScrollBarBlackBorderTextBox() {
    scrollBarTextBox = new ScrollBarTextBox();
    blackBorderTextBox = new BlackBorderTextBox();
  }

  void display(){
    scrollBarTextBox.setScrollBar();
    blackBorderTextBox.setBlackBorder();
    System.out.println("show ScrollBar BlackBorder TextBox");

  }
}
