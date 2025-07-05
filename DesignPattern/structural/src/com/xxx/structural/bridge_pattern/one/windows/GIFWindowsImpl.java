package com.xxx.structural.bridge_pattern.one.windows;

import com.xxx.structural.bridge_pattern.one.GIFImage;

public class GIFWindowsImpl extends GIFImage {
    public void show(){
        parse();
        System.out.println("windows show gif");
    }
}
