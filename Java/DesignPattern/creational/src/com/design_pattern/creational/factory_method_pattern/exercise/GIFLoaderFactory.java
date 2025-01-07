package com.design_pattern.creational.factory_method_pattern.exercise;

public class GIFLoaderFactory implements ImgLoaderFactory {
    @Override
    public ImgLoader createLoader() {
        System.out.println("create GIF loader");
        return new GIFLoader();
    }
}
