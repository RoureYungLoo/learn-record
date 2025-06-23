package com.luruoyang;

public class JavaException {
  public static void main(String[] args) {

    try {
      System.out.println("in try block");
      int err = 1 / 0;
    } catch (Exception e) {
      System.out.println("in catch block");
    } finally {
      System.out.println("in finally block");
    }
  }
}
