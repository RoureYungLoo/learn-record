package com.design_pattern.creational.singleton_pattern.eager;

public class EagerSingleton {
//    线程安全，类加载时创建
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
