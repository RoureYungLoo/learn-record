package com.design_pattern.creational.simple_factory_pattern.exercise;

import com.design_pattern.creational.simple_factory_pattern.exercise.exception.UnSupportedShapeException;
import com.design_pattern.creational.simple_factory_pattern.exercise.shape.Shape;

public class MainApp {
    public static void main(String[] args) {
        Shape shape = null;
        try {
            shape = ShapeFactory.getShape("r");
        } catch (UnSupportedShapeException e) {
            e.printStackTrace();
        }
        shape.draw();
        shape.erase();
    }
}
