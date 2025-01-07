package com.design_pattern.creational.abstract_factory_pattern.gui_skins_v1;

/* 具体工厂 */
public class SpringComboFactory implements ComboFactory {
    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
