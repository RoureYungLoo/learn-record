package com.design_pattern.creational.abstract_factory_pattern.gui_skins_v2;

import com.design_pattern.creational.factory_method_pattern.logger.v3.XMLUtils;
import com.design_pattern.creational.simple_factory_pattern.level2.Factory;
import com.design_pattern.creational.simple_factory_pattern.level3.XMLUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class v2Client {
    public static void main(String[] args) throws Exception, InstantiationException, IllegalAccessException {
//        SkinFactory factory = new SummerSkinFactory();
//        Button button = factory.createButton();
//        button.display();

        SkinFactory factory1;
        Button button1;
        ComboBox comboBox1;
        TextField textField1;

        /* 利用反射 */
        // 类名可以从配置文件中读取，例如xml文件、properties文件、yml文件、json文件、甚至是网络请求响应中的类名
        String skinFactoryClassName = "com.design_pattern.creational.abstract_factory_pattern.gui_skins_v2.SpringSkinFactory";
        Class<?> clazz = Class.forName(skinFactoryClassName);
        Constructor<?> constructor = clazz.getConstructor();
        Object obj = constructor.newInstance();
        factory1=(SkinFactory) obj;
        button1=factory1.createButton();
        comboBox1=factory1.createComboBox();
        textField1=factory1.createTextField();
        button1.display();
        comboBox1.display();
        textField1.display();
    }
}
