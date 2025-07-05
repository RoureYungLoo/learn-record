package com.xxx.structural.bridge_pattern.one.windows;

import com.xxx.structural.bridge_pattern.one.JPGImage;

public class JPGWindowsImpl extends JPGImage {
    public void show(){
        parse();
        System.out.println("windows show jpg");
    }
}
