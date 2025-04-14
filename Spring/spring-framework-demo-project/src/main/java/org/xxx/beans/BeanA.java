package org.xxx.beans;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope("singleton")
public class BeanA {

//    @Autowired
//    private  BeanB beanB;
//
//
//
////    @Autowired
//    public BeanA(BeanB beanB) {
//        this.beanB = beanB;
//    }

//    @Autowired
//    public void setBeanB(BeanB beanB) {
//        this.beanB = beanB;
//    }
}
