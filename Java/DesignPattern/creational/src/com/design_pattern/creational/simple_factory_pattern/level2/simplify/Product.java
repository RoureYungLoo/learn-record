package com.design_pattern.creational.simple_factory_pattern.level2.simplify;

public abstract class Product {
    public static Product getProduct(String args) {
        Product product = null;
        switch (args) {
            case "A":
                product = new ConcreteProductA();
                break;
            case "B":
                product = new ConcreteProductB();
                break;
            default:
                product = new ConcreteProduct();
        }
        return product;
    }

    public void methodCommon() {
        System.out.println("Simplify Product Common Method");
    }

    public abstract void methodDiff();
}
