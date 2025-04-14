package org.xxx.beans;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope("singleton")
public class BeanB {

////    @Autowired
//    private  BeanA beanA;
//
////    @Autowired
////    public BeanB(BeanA beanA) {
////        this.beanA = beanA;
////    }
//
//    @Autowired
//    public void setBeanA(BeanA beanA) {
//        this.beanA = beanA;
//    }
}
