package com.design_pattern.creational.abstract_factory_pattern.gui_skins_v1;

public class v1Client {
    public static void main(String[] args) {
        ButtonFactory buttonFactory = new SummerButtonFactory();
        Button button = buttonFactory.createButton();
        button.showButton();
    }
}
