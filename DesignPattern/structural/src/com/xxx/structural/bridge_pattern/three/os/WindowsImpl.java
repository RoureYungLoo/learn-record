package com.xxx.structural.bridge_pattern.three.os;

import com.xxx.structural.bridge_pattern.three.ImageImpl;
import com.xxx.structural.bridge_pattern.three.Matrix;

public class WindowsImpl implements ImageImpl {
    @Override
    public void doPaint(Matrix matrix) {
        System.out.println("在Windows中显示图像：");
    }
}
