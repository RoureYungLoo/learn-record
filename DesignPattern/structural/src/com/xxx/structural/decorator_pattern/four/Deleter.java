package com.xxx.structural.decorator_pattern.four;

/* 具体装饰器 */
public class Deleter extends Decorator {
  public Deleter(Document document) {
    super(document);
    System.out.println("增加删除功能");

  }

  @Override
  public void display() {
    super.display();
  }

  public void delete() {
    System.out.println("正在删除中....");
    System.out.println("删除完毕!");
  }
}

