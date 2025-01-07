package com.xxx.structural.bridge_pattern.one.linux;

import com.xxx.structural.bridge_pattern.one.PNGImage;

public class PNGLinuxImpl extends PNGImage {
    public void show(){
        parse();
        System.out.println("linux show png");
    }
}
