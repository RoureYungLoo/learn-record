package com.xxx.structural.bridge_pattern.one.unix;

import com.xxx.structural.bridge_pattern.one.GIFImage;

public class GIFUnixImpl extends GIFImage {
    public void show(){
        parse();
        System.out.println("unix show gif");
    }
}
