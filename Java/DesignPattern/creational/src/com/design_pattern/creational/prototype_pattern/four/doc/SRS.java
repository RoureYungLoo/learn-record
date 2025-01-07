package com.design_pattern.creational.prototype_pattern.four.doc;

public class SRS implements OfficialDocument {
    @Override
    public OfficialDocument clone() {
        OfficialDocument srs=null;
        try {
            srs= (OfficialDocument) super.clone();
        } catch (Exception e) {
            System.out.println("不支持复制");;
        }
        return srs;
    }

    @Override
    public void display() {
        System.out.println("软件需求规格说明书");
    }
}
