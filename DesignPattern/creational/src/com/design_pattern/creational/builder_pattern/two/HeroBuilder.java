package com.design_pattern.creational.builder_pattern.two;

/* 具体建造者 */
public class HeroBuilder extends ActorBuilder {
    @Override
    void buildType() {
        actor.setType("hero");
    }

    @Override
    void buildSex() {
        actor.setSex("male");
    }

    @Override
    void buildFace() {
        actor.setFace("英俊");
    }

    @Override
    void buildCostume() {
        actor.setCostume("盔甲");
    }

    @Override
    void buildHairstyle() {
        actor.setHairstyle("飘逸");
    }

}
