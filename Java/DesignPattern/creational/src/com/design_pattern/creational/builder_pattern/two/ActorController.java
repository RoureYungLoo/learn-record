package com.design_pattern.creational.builder_pattern.two;

/* 指挥者 */
public class ActorController {
    public Actor construct(ActorBuilder ab) {
        Actor actor;

        ab.buildType();
        ab.buildCostume();
        ab.buildFace();
//        ab.buildHairstyle();
        ab.buildSex();

        /* 精细控制 */
        if (!ab.isBareHeaded()){
            ab.buildHairstyle();
        }

        actor = ab.createActor();
        return actor;
    }

}
