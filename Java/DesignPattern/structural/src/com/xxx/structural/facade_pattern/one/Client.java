package com.xxx.structural.facade_pattern.one;

/* 客户端 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.Method();

//        SubSystemA systemA = new SubSystemA();
//        SubSystemB systemB = new SubSystemB();
//        SubSystemC systemC = new SubSystemC();
//        systemA.MethodA();
//        systemB.MethodB();
//        systemC.MethodC();
    }
}
