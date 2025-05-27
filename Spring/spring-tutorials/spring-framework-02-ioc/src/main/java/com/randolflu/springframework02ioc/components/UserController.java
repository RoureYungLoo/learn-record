package com.randolflu.springframework02ioc.components;


//@RestController
public class UserController {
    private String name = this.getClass().getName();

    @Override
    public String toString() {
        return "UserController{" +
                "name='" + name + '\'' +
                '}';
    }
}
