package com.randolflu.springframework02ioc.config2;

import com.randolflu.springframework02ioc.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 普通类 */
public class CarEntity {

    @Bean
    public Car benz() {
        return Car.createCar("宝马");
    }
}
