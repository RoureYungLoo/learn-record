package com.xxx.structural.bridge_pattern.one.linux;

import com.xxx.structural.bridge_pattern.one.JPGImage;

public class JPGLinuxImpl extends JPGImage {
    public void show(){
        parse();
        System.out.println("linux show jpg");
    }
}
