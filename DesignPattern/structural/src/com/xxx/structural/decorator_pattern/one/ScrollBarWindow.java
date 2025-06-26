package com.xxx.structural.decorator_pattern.one;

public class ScrollBarWindow extends Window {
  @Override
  void display() {
    setScrollBar();
    System.out.println("show ScrollBarWindow");
  }
  void setScrollBar(){
    System.out.println("set Window ScrollBar");
  }
}
