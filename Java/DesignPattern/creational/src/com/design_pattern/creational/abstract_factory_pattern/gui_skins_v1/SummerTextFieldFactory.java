package com.design_pattern.creational.abstract_factory_pattern.gui_skins_v1;

/* 具体工厂 */
public class SummerTextFieldFactory implements TextFieldFactory {
    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
}
