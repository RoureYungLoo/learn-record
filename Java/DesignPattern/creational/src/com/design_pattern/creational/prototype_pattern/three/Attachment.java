package com.design_pattern.creational.prototype_pattern.three;

import java.io.Serializable;

//public class Attachment { // 浅克隆
public class Attachment implements Serializable { // 深克隆
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void download(){
        System.out.println("下载附件文件名： "+name);
    }
}
