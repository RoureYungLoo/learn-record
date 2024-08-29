package com.xxx.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Hunter {
/*-------------------- @Autowired ----------------------*/
    /* Autowired是按类型自动转配的，不支持id匹配 */
    // @Autowired
    // @Autowired(required = false) 可以为 null
    // private Dog dog;
    // @Autowired
    // @Autowired(required = true) 不能为 null
    // private Pig pig;


/*-------------------- @Autowired + @Qualifier ----------------------*/
//    @Autowired
//    @Qualifier(value = "dog")
//    private Dog dog;
//
//    @Autowired
//    @Qualifier(value = "pig")
//    private Pig pig;


/*-------------------- @Resource ----------------------*/
    @Resource(name = "dog")
    private Dog dog;
    @Resource(name = "pig")
    private Pig pig;



    private String str;

    public Dog getDog() {
        return dog;
    }

    public Pig getPig() {
        return pig;
    }

    public String getStr() {
        return str;
    }
}
