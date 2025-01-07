package com.xxx.structural.bridge_pattern.three.image;

import com.xxx.structural.bridge_pattern.three.Image;
import com.xxx.structural.bridge_pattern.three.Matrix;


public class BMPImage extends Image {

    @Override
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        impl.doPaint(matrix);
        System.out.println(fileName+"格式为BMP");
    }
}
