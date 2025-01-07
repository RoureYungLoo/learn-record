package org.example.domain;

public class Student {
    private Long id;
    private String name;
    private Integer height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        System.out.println("student name: "+name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void throwAnException(){
        System.out.println("throw an exception");
        throw new IllegalArgumentException("出错了");
    }

}
