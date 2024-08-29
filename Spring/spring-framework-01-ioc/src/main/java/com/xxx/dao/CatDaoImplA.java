package com.xxx.dao;

public class CatDaoImplA implements CatDao{
    @Override
    public void findAll() {
        System.out.println("cat dao A findAll()");
    }
}
