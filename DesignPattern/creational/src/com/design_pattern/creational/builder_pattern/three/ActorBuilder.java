package com.design_pattern.creational.builder_pattern.three;

import com.design_pattern.creational.builder_pattern.two.Actor;

/* 抽象建造者 */
/* 优化： 省略Director角色，将construct()方法合并到抽象建造者 */
public abstract class ActorBuilder {
    /*Actor actor = new Actor();*/

    protected static Actor actor = new Actor();

    abstract void buildType();

    abstract void buildSex();

    abstract void buildFace();

    abstract void buildCostume();

    abstract void buildHairstyle();

    /*Actor createActor() {
        return actor;
    }*/

    /* 省略Director角色 */
    public static Actor construct(ActorBuilder ab) {
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        return actor;
    }

    /* 还能再优化 */
    public Actor construct2() {
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        this.buildHairstyle();
        return actor;
    }


}
