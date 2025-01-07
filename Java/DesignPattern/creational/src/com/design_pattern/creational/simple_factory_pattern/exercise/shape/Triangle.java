package com.design_pattern.creational.simple_factory_pattern.exercise.shape;

public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("draw a Triangle");

    }

    @Override
    public void erase() {
        System.out.println("erase a Triangle");

    }
}
