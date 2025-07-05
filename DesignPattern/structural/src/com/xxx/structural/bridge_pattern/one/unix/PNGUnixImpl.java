package com.xxx.structural.bridge_pattern.one.unix;

import com.xxx.structural.bridge_pattern.one.PNGImage;

public class PNGUnixImpl extends PNGImage {
    public void show(){
        parse();
        System.out.println("unix show png");
    }
}
