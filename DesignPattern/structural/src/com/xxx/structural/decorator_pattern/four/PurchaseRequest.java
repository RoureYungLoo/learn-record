package com.xxx.structural.decorator_pattern.four;

/* 具体组件 */
public class PurchaseRequest implements Document {
  @Override
  public void display() {
    System.out.println(" display purchase request ");
  }
}
