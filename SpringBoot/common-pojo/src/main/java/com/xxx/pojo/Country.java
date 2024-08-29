package com.xxx.pojo;

public class Country {
    private String name;
    private String system;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", system='" + system + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Country() {
    }

    public Country(String name, String system) {
        this.name = name;
        this.system = system;
    }
}
