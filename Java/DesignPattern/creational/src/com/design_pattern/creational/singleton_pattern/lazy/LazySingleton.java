package com.design_pattern.creational.singleton_pattern.lazy;

public class LazySingleton {
//    private static LazySingleton instance = null;
    // 双重检查锁需要使用volatile
    private volatile static LazySingleton instance = null;

//    synchronized public static LazySingleton getInstance() {
//        if (instance == null) {
//            // 存在并发安全, 添加synchronized以保证线程安全
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

//    public static LazySingleton getInstance() {
//        if (instance == null) {
//            synchronized (LazySingleton.class) {
//                 存在并发安全, 添加synchronized以保证线程安全
//                instance = new LazySingleton();
//            }
//        }
//        return instance;
//    }

    public static LazySingleton getInstance() {

        if (instance == null) {
            synchronized (LazySingleton.class) {
                // 存在并发安全, 添加synchronized以保证线程安全
                if (instance == null) { // 双重检查锁
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    private LazySingleton() {
    }
}
