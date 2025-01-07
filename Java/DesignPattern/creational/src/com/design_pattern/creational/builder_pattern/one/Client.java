package com.design_pattern.creational.builder_pattern.one;

public class Client {
    public static void main(String[] args) {

        Builder builder = new ConcreteBuilder(); // 可以通过配置文件 + 反射实现
        Director director = new Director(builder);
        Product product = director.construct();
    }
}
