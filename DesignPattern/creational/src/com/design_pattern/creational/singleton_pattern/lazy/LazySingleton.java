package com.design_pattern.creational.singleton_pattern.lazy;

/* 单例模式, 懒汉式, 延迟加载, Lazy Loading */
public class LazySingleton {
  private static LazySingleton instance = null;

  // 双重检查锁需要使用volatile
//  private volatile static LazySingleton instance = null;

  // 懒汉式单例
    /*
    synchronized public static LazySingleton getInstance() {
        if (instance == null) {
            // 此处存在并发安全, 添加 synchronized 以保证线程安全, 但效率不高
            instance = new LazySingleton();
        }
        return instance;
    }*/

    /*public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                 // 存在并发安全, 添加synchronized以保证线程安全, 优化 synchronized 的粒度
                instance = new LazySingleton();
            }
        }
        return instance;
    }*/

  /*public static LazySingleton getInstance() {
    *//* 第一重判断 *//*
    if (instance == null) {
      *//* 存在并发安全, 添加synchronized以保证线程安全 *//*
      synchronized (LazySingleton.class) {
        *//* 第二重判断, 即双重检查锁 DCL *//*
        if (instance == null) {
          instance = new LazySingleton();
        }
      }
    }
    return instance;
  }*/

  private LazySingleton() {
  }
}
