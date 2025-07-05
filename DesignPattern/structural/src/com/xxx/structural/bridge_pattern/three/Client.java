package com.xxx.structural.bridge_pattern.three;

import com.xxx.utils.XMLUtils;

public class Client {
    public static void main(String[] args) {
        Image image;
        ImageImpl impl;

//        image= (Image) XMLUtils.gerBean("image");
//         impl = (ImageImpl) XMLUtils.gerBean("os");
//
//         image.setImageImpl(impl);
//         image.parseFile("喜马拉雅山");
//
//        String osArch = System.getProperty("os.name");
//        System.out.println(osArch);

        impl = (ImageImpl) XMLUtils.gerBean("os");
        image = (Image) XMLUtils.gerBean("喜马拉雅.png");

        image.setImageImpl(impl);

        image.parseFile("喜马拉雅.png");
    }
}
