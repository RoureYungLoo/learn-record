package com.design_pattern.creational.builder_pattern.two;

/* 抽象建造者 */
public abstract class ActorBuilder {
    Actor actor = new Actor();

    abstract void buildType();

    abstract void buildSex();

    abstract void buildFace();

    abstract void buildCostume();

    abstract void buildHairstyle();

    Actor createActor() {
        return actor;
    }

    /* 添加钩子函数，用于精细控制 */
    public Boolean isBareHeaded(){
        return Boolean.FALSE;
    }

}
