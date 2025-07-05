package com.design_pattern.creational.simple_factory_pattern.level2;

/* 简单工厂方法模式（静态工厂方法模式） */
public class Factory {
    public static Product getProduct(String args) {
        Product product = null;
        if (args.equalsIgnoreCase("A")) {
            product = new ConcreteProductA();
        } else if (args.equalsIgnoreCase("B")) {
            product = new ConcreteProductB();
        } else {
            product = new ConcreteProduct();
        }

        /* 缺点：每次引入新产品，就要修改静态工厂方法 */

        return product;
    }
}
