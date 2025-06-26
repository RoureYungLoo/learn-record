package com.xxx.structural.decorator_pattern.one;

public class ScrollBarBlackBorderListBox {
  private ScrollBarListBox scrollBarListBox;
  private BlackBorderListBox blackBorderListBox;

  public ScrollBarBlackBorderListBox() {
    this.scrollBarListBox = new ScrollBarListBox();
    this.blackBorderListBox = new BlackBorderListBox();
  }

  void display(){
    scrollBarListBox.setScrollBar();
    blackBorderListBox.setBlackBorder();
    System.out.println("show ScrollBar BlackBorder ListBox");
  }
}
