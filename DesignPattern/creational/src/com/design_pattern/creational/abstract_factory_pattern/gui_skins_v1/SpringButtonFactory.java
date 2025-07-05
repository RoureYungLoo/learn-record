package com.design_pattern.creational.abstract_factory_pattern.gui_skins_v1;
/* 具体工厂 */
public class SpringButtonFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }
}
