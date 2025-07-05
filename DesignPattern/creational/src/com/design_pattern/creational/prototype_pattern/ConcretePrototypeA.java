package com.design_pattern.creational.prototype_pattern;

public class ConcretePrototypeA implements Prototype{
    private String attr;
    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototypeA();
        prototype.setAttr(this.attr);
        return prototype;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA{" +
                "attr='" + attr + '\'' +
                '}';
    }
}
