package com.design_pattern.creational.singleton_pattern.iodh;

public class Singleton {
  /* 私有构造器 */
  private Singleton() {
  }

  /* 私有静态内部类 */
  private static class HolderClass {
    private static final Singleton instance = new Singleton();

    static {
      /* com.design_pattern.creational.singleton_pattern.iodh.Singleton$HolderClass is being loading... */
      System.out.println(HolderClass.class.getName() + " is being loading...");
    }

  }

  /* 公有方法 */
  public static Singleton getInstance() {
    return HolderClass.instance;
  }

  public static void main(String[] args) {
    Singleton s1, s2;
    s1 = Singleton.getInstance();
    s2 = Singleton.getInstance();
    System.out.println(s1 == s2);
  }
}
