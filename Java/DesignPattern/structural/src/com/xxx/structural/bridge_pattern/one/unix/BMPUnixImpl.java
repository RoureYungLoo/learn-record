package com.xxx.structural.bridge_pattern.one.unix;

import com.xxx.structural.bridge_pattern.one.BMPImage;

public class BMPUnixImpl extends BMPImage {
    public void show(){
        parse();
        System.out.println("unix show bmp");
    }
}
