package com.learn;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.convert.Convert;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(Convert.toStr(666));
        System.out.println(Convert.toStr(new long[]{1,3,4}));

        String[] b = { "1", "2", "3", "4" };
        Integer[] intArray = Convert.toIntArray(b);
        long[] c = {1,2,3,4,5};
        Integer[] intArray2 = Convert.toIntArray(c);
        System.out.println(Arrays.toString(intArray2));

        String date = "2017-05-06";
        LocalDateTime localDateTime = Convert.toLocalDateTime(date);
        System.out.println(localDateTime);

        Object[] objects = {"Hello",1234,"a"};
        List list = Convert.convert(List.class, objects);
        System.out.println(list);

        List<?> objects1 = Convert.toList(objects);
        System.out.println(objects1);

//        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 20);
        LineCaptcha captcha=CaptchaUtil.createLineCaptcha(200,100);
        captcha.write("C:\\Users\\RuoYang\\Desktop\\captcha.png");

    }


}
