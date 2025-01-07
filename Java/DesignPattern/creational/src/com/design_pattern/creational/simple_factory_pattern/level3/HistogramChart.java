package com.design_pattern.creational.simple_factory_pattern.level3;

/* 具体产品角色 */
public class HistogramChart extends Chart {
    public HistogramChart() {
        System.out.println("创建柱状图");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图");
    }

}
