package com.xxx.structural.decorator_pattern.one;

public class ScrollBarTextBox extends TextBox {
  @Override
  void display() {
   setScrollBar();
    System.out.println("show ScrollBarTextBox");
  }

  void setScrollBar(){
    System.out.println("set TextBox ScrollBar");
  }
}
