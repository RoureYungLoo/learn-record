package org.example.domain;

public class Day {
    private String day;
    private Integer order;

    public Day() {
        System.out.println("Day constructor");
    }

    public void init(){
        System.out.println("Day init");
    }

    public void destroy(){
        System.out.println("Day destroy");
    }
}
