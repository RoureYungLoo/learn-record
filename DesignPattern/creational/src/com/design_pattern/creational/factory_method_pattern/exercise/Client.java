package com.design_pattern.creational.factory_method_pattern.exercise;

public class Client {
    public static void main(String[] args) {

//        ImgLoaderFactory factory = new GIFLoaderFactory();
        ImgLoaderFactory factory = new JPGLoaderFactory();
        ImgLoader loader = factory.createLoader();
        loader.load();
    }
}
