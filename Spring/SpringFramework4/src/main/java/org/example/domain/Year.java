package org.example.domain;

public class Year {
    private String year;
    private Integer number;

    public Year() {
        System.out.println("Year constructor");
    }

    public void init(){
        System.out.println("Year init");
    }
    public void destroy(){
        System.out.println("Year destroy");
    }
}