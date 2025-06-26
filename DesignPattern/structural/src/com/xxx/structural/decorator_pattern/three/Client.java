package com.xxx.structural.decorator_pattern.three;

public class Client {
  public static void main(String[] args) {
    /* 透明模式:  具体组件 和 具体装饰器 全部使用 抽象组件 声明 */
    Component component,
        componentScrollBar,
        componentBlackBorder;
    // 实例化具体组件
    component = new Window(); // 具体组件
    // 实例化具体装饰器
    componentScrollBar = new ScrollBarDecorator(component); // 具体装饰器
    // 实例化具体装饰器
    componentBlackBorder = new BlackBorderDecorator(componentScrollBar);
    // 调用功能
    componentBlackBorder.display(); // 多态
  }
}
