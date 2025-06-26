package com.xxx.structural.decorator_pattern.one;

public class BlackBorderWindow extends Window {
  @Override
  void display() {
    setBlackBorder();
    System.out.println("show BlackBorderWindow");
  }

  void setBlackBorder() {
    System.out.println("set Window BlackBorder");
  }
}
