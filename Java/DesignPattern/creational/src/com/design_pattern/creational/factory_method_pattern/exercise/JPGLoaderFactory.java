package com.design_pattern.creational.factory_method_pattern.exercise;

public class JPGLoaderFactory implements ImgLoaderFactory{
    @Override
    public ImgLoader createLoader() {
        System.out.println("create JPG loader");
        return new JPGLoader();
    }
}
