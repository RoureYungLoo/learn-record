package com.xxx.structural.proxy_pattern.two;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> clazz = Class.forName("com.xxx.structural.proxy_pattern.two.ProxySearcher");
        Constructor<?> constructor = clazz.getConstructor();
        Object o = constructor.newInstance(); // 反射获取代理对象

        ProxySearcher proxySearcher = (ProxySearcher) o;

        Searcher searcher = proxySearcher; // 多态体现之一, 面向接口抽象编程, 接口变量引用指向实现类对象
        String result = searcher.DoSearch("zhangsan", "天龙八部");
        System.out.println("result:" + result);

        System.out.printf("\n\n");

        Class<?> newClass = Class.forName("com.xxx.structural.proxy_pattern.two.NewProxySearcher");
        Constructor<?> noArgConstructor = newClass.getConstructor();
        Object newInstance = noArgConstructor.newInstance();
        NewProxySearcher newProxySearcher = (NewProxySearcher) newInstance;
//
        Searcher newSearcher = newProxySearcher;
        String res = newProxySearcher.DoSearch("李四", "红楼梦");
        System.out.println(res);

    }
}
