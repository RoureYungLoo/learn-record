package com.xxx.structural.bridge_pattern.one.linux;

import com.xxx.structural.bridge_pattern.one.GIFImage;

public class GIFLinuxImpl extends GIFImage {
    public void show(){
        parse();
        System.out.println("linux show gif");
    }
}
