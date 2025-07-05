package com.design_pattern.creational.abstract_factory_pattern.gui_skins_v2;

/* 具体产品 */
public class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("SpringButton");
    }
}
