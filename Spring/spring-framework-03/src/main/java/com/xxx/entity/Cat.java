package com.xxx.entity;

import java.util.PriorityQueue;

public class Cat {
    private String category;

    public Cat() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Cat(String category) {
        this.category = category;
    }
    public void show(){
        System.out.println("I am a "+category+" cat");
    }

    public void say(){
        System.out.println("miao~");
    }
}
