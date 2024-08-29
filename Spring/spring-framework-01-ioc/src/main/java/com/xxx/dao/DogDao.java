package com.xxx.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DogDao {
    public void findAll(){
        System.out.println("查询所有");
    }
}
