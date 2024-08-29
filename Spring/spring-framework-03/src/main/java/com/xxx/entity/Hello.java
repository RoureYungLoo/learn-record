package com.xxx.entity;

public class Hello {
    private String name;

    public void show(){
        System.out.println("Hello "+name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
