package com.design_pattern.creational.abstract_factory_pattern.gui_skins_v2;

/* 抽象工厂 */
public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    ComboBox createComboBox();
}
