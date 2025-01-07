package com.xxx.structural.proxy_pattern.two;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> clazz = Class.forName("com.xxx.structural.proxy_pattern.two.ProxySearch");
        Constructor<?> constructor = clazz.getConstructor();
        Object o = constructor.newInstance(); // 反射获取代理对象

        Searcher searcher = (Searcher) o; //
        String result = searcher.DoSearch("zhangsan", "天龙八部");
        System.out.println("result:"+ result);
    }
}
