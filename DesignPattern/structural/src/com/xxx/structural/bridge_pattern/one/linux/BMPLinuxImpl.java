package com.xxx.structural.bridge_pattern.one.linux;

import com.xxx.structural.bridge_pattern.one.BMPImage;

public class BMPLinuxImpl extends BMPImage {
    public void show(){
        parse();
        System.out.println("linux show bmp");
    }
}
