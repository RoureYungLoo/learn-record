package com.design_pattern.creational.singleton_pattern.eager;
/* 单例模式, 饿汉式 */
public class EagerSingleton {
  /*线程安全，类加载时创建, final 防止单例实例引用被修改*/
  private static final EagerSingleton instance = new EagerSingleton();

  private EagerSingleton() {
  }

  public static EagerSingleton getInstance() {
    return instance;
  }
}
