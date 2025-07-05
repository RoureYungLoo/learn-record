package com.design_pattern.creational.singleton_pattern;

public class Singleton {
    private static Singleton st = null;

    private Singleton() {
        System.out.println("Singleton constructor");
    }

    public static Singleton getInstance() {
        if (st == null) {
            st = new Singleton();
        }
        return st;
    }
}
