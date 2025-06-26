package com.xxx.structural.decorator_pattern.one;

public class BlackBorderTextBox extends TextBox {
  @Override
  void display() {

    setBlackBorder();
    System.out.println("show BlackBorderTextBox");
  }

  void setBlackBorder(){
    System.out.println("set TextBox BlackBorder");
  }
}
