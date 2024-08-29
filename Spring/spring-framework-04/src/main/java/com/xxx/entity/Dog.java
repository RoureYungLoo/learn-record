package com.xxx.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog {
    @Value("Teddy")
    private String category;

    public void show(){
        System.out.println("I am a Teddy dog");
    }
}
