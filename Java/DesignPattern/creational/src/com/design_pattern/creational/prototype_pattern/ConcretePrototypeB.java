package com.design_pattern.creational.prototype_pattern;

public class ConcretePrototypeB implements Prototype {
    private String attr;

    @Override
    public Prototype clone() {
//        Prototype prototype = new ConcretePrototypeB();
//        prototype.setAttr(this.attr);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            // 必须实现Cloneable接口，才能调用Clone方法
            System.err.println("Not Support Cloneable");
        }

        return (Prototype) obj;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "ConcretePrototypeB{" +
                "attr='" + attr + '\'' +
                '}';
    }
}
