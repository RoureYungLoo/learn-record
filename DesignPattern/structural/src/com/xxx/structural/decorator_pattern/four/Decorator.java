package com.xxx.structural.decorator_pattern.four;

/* 抽象装饰器类 */
public abstract class Decorator implements Document {

  /* 持有 抽象组件 */
  private Document document;

  public Decorator(Document document) {
    this.document = document;
  }

  public void display() {
    document.display();
  }
}
