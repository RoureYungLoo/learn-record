package com.xxx.structural.decorator_pattern.four;

/* 具体装饰器 */
public class Approver extends Decorator {
  public Approver(Document document) {
    super(document);
    System.out.println("增加审批功能");
  }

  @Override
  public void display() {
    super.display();
  }

  /* 新增的功能 */
  public void approve() {
    System.out.println("正在审批中...");
    System.out.println("审批完毕!");
  }
}
