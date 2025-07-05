package com.xxx.structural.bridge_pattern.two;

/* 抽象类 */
public abstract class Abstraction {
    protected Implementor impl; // 定义实现类接口对象

    public void setImpl(Implementor impl) {
        this.impl = impl;
    }

    public abstract void operation(); // 声明抽象业务方法
}
