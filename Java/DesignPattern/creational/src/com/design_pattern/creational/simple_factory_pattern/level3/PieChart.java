package com.design_pattern.creational.simple_factory_pattern.level3;

/* 具体产品角色 */

public class PieChart extends Chart {
    public PieChart() {
        System.out.println("创建饼状图");
    }

    public void display() {
        System.out.println("显示饼状图");
    }
}
