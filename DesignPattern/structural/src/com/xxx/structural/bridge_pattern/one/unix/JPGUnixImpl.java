package com.xxx.structural.bridge_pattern.one.unix;

import com.xxx.structural.bridge_pattern.one.JPGImage;

public class JPGUnixImpl extends JPGImage {
    public void show(){
        parse();
        System.out.println("unix show jpg");
    }
}
