package com.xxx.pojo;

public class Province {
    private String name;
    private String direction;

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Province() {
    }

    public Province(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }
}
