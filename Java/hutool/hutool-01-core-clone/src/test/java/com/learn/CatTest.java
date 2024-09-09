package com.learn;

import cn.hutool.core.util.ObjectUtil;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

public class CatTest {

    @Test
    public void testCloneCat() throws Exception {
        Address address = new Address(460000, "河南");
        Cat cat = new Cat("小猫", "布偶",address);

        Cat clone = cat.clone();
        System.out.println(cat==clone);

        clone.getAddress().setProvince("henan"); // 浅克隆

        Cat cloneByStream = ObjectUtil.cloneByStream(cat); //深克隆
        cloneByStream.getAddress().setProvince("HeNan");

        System.out.println(cat);
//        System.out.println(cat.clone());

    }

    @Test
    public void test2() {
//        // BitSet
//        enum Color{
//            RED
//        }
//        int c = Color.RED.ordinal();
//        StackTraceElement stackTraceElement = new StackTraceElement();
//        System.out.println(stackTraceElement.getClassLoaderName());


    }


}

