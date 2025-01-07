package com.design_pattern.creational.simple_factory_pattern.exercise;

import com.design_pattern.creational.simple_factory_pattern.exercise.exception.UnSupportedShapeException;
import com.design_pattern.creational.simple_factory_pattern.exercise.shape.Circle;
import com.design_pattern.creational.simple_factory_pattern.exercise.shape.Rectangle;
import com.design_pattern.creational.simple_factory_pattern.exercise.shape.Shape;
import com.design_pattern.creational.simple_factory_pattern.exercise.shape.Triangle;

public class ShapeFactory {
    public static Shape getShape(String args) throws UnSupportedShapeException {
        Shape shape = null;
        switch (args) {
            case "c":
                shape = new Circle();
                break;
            case "r":
                shape = new Rectangle();
                break;
            case "t":
                shape = new Triangle();
                break;
            default:
                throw new UnSupportedShapeException("unsupported shape: " + args);
        }
        return shape;
    }
}
