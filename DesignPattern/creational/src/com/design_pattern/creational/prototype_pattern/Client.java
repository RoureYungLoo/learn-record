package com.design_pattern.creational.prototype_pattern;

public class Client {
    public static void main(String[] args) {
        Prototype obj1 = new ConcretePrototypeA();
        obj1.setAttr("Sunny");
        Prototype obj2 = obj1.clone();
        System.out.println(obj2);

    }
}
