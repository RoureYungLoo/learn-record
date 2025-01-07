package com.design_pattern.creational.factory_method_pattern;

public class Client{
    public static void main(String[] args) {
        /* 具体工厂 */
        Factory factory = new ConcreteFactory();
        /* 具体产品 */
        Product product = factory.getProduct();
        System.out.println(product);
    }
}
