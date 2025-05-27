package com.randolflu.springframework02ioc.entity;

public class CarFactory {
    public Car buildCar(String brand) {
        System.out.println("----- instance factory method");
        return Car.createCar(brand); // 调用静态工厂方法
    }
}
