package com.design_pattern.creational.builder_pattern.three;

import com.design_pattern.creational.builder_pattern.two.Actor;
import com.design_pattern.creational.builder_pattern.two.ActorController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 通过反射拿到类名，获取构造函数，再实例化
        String builderName = "com.design_pattern.creational.builder_pattern.three.DevilBuilder";
        Class<?> clazz = Class.forName(builderName);
        Constructor<?> constructor = clazz.getConstructor();
        ActorBuilder ac = (ActorBuilder) constructor.newInstance();

//        ActorController ac = new ActorController();
//        Actor actor = ac.construct((ActorBuilder) o);
//        Actor actor = ac.construct2();
        Actor actor = ActorBuilder.construct(ac);

        System.out.println(actor.getSex());
        System.out.println(actor.getCostume());
        System.out.println(actor.getFace());
        System.out.println(actor.getHairstyle());
        System.out.println(actor.getType());
    }
}
