package com.xxx.structural.decorator_pattern.one;

public class Client {
  public static void main(String[] args) {
    ScrollBarBlackBorderListBox scrollBarBlackBorderListBox = new ScrollBarBlackBorderListBox();
    scrollBarBlackBorderListBox.display();

    ScrollBarBlackBorderTextBox scrollBarBlackBorderTextBox = new ScrollBarBlackBorderTextBox();
    scrollBarBlackBorderTextBox.display();

    ScrollBarBlackBorderWindow scrollBarBlackBorderWindow = new ScrollBarBlackBorderWindow();
    scrollBarBlackBorderWindow.display();
  }
}
