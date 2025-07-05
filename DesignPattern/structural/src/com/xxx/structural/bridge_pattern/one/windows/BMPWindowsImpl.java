package com.xxx.structural.bridge_pattern.one.windows;

import com.xxx.structural.bridge_pattern.one.BMPImage;

public class BMPWindowsImpl extends BMPImage {
    public void show(){
        parse();
        System.out.println("windows show bmp");
    }
}
