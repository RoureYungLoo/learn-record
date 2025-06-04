package com.xxx.structural.facade_pattern.one;

/* 外观类   门面类 */
public class Facade {
    private SubSystemA obj1;
    private SubSystemB obj2;
    private SubSystemC obj3;

    public Facade() {
        obj1 = new SubSystemA();
        obj2 = new SubSystemB();
        obj3 = new SubSystemC();
    }

    public void Method() {
        obj1.MethodA();
        obj2.MethodB();
        obj3.MethodC();
    }
}
