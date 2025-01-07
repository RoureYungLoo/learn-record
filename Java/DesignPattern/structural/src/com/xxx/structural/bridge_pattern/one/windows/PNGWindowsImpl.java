package com.xxx.structural.bridge_pattern.one.windows;

import com.xxx.structural.bridge_pattern.one.PNGImage;

public class PNGWindowsImpl extends PNGImage {
    public void show(){
        parse();
        System.out.println("windows show png");
    }
}
