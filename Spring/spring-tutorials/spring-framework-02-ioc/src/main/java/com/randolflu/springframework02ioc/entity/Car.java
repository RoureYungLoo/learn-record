package com.randolflu.springframework02ioc.entity;

public class Car {
    private String brand;

    private Car(String brand) { // 私有构造器
        this.brand = brand;
    }

    // 静态工厂方法
    public static Car createCar(String brand) {
        System.out.println("------- static factory method");
        return new Car(brand);
    }
}