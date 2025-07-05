package com.design_pattern.creational.simple_factory_pattern.level3;

/* 具体产品角色 */
public class LineChart extends Chart{
    public LineChart() {
        System.out.println("创建折线图");
    }

    @Override
    public void display() {
        System.out.println("显示折线图");
    }
}
