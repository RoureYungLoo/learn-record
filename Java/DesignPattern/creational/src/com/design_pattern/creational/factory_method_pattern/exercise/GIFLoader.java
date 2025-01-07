package com.design_pattern.creational.factory_method_pattern.exercise;

public class GIFLoader implements ImgLoader{
    @Override
    public void load() {
        System.out.println("load gif");
    }
}
