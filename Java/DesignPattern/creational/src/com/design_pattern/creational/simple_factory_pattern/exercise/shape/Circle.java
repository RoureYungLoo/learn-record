package com.design_pattern.creational.simple_factory_pattern.exercise.shape;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("draw a circle");
    }

    @Override
    public void erase() {
        System.out.println("erase a circle");

    }
}
