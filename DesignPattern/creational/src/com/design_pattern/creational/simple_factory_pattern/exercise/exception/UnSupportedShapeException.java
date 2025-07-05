package com.design_pattern.creational.simple_factory_pattern.exercise.exception;

public class UnSupportedShapeException extends Exception{
    private String message;

    public UnSupportedShapeException(String message) {
        super(message);
        this.message = message;
    }
}
