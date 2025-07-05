package com.design_pattern.creational.builder_pattern.two;

/* 具体建造者 */

public class DevilBuilder extends ActorBuilder {
    @Override
    void buildType() {
        actor.setType("恶魔");
    }

    @Override
    void buildSex() {
        actor.setSex("male");
    }

    @Override
    void buildFace() {
        actor.setFace("鬼脸");
    }

    @Override
    void buildCostume() {
        actor.setCostume("服装");
    }

    @Override
    void buildHairstyle() {
        actor.setHairstyle("光头");
    }

    @Override
    public Boolean isBareHeaded() {
        return Boolean.TRUE;
    }
}
