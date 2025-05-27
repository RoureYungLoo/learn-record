package com.randolflu.springframework02ioc.entity;

public class Hello {
    private String name;

    public String getHelloStr() {
        return "Hello World IoC! By " + name;
    }

    public String getName() {
        return name;
    }

    public Hello(String name) {
        this.name = name;
    }

    public Hello() {
    }

    public void setName(String name) {
        this.name = name;

    }
}
