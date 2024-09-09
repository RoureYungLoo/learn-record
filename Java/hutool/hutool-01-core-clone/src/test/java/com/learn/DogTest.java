package com.learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    @Test
    public void testDog(){
        Dog dog = new Dog("小狗", "泰迪");
        Dog clone = dog.clone();
        System.out.println(dog==clone);
    }

}