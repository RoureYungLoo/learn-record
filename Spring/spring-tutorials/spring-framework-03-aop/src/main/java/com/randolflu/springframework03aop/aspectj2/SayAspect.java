package com.randolflu.springframework03aop.aspectj2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//@Aspect
//@Component
//@Order(2)
public class SayAspect {
//    @DeclareParents(value = "com.randolflu.springframework03aop.aspectj2.*"
//            , defaultImpl = DefaultGoodBye.class)
    private GoodBye goodBye;


//    @Before("execution(* say*(..))&& args(sb)")
    public void count(StringBuffer sb) {
//        sb.append("@Order(2) [ ");
//        sb.append(++counter);
//        sb.append(" ] ");
        sb.append("[" + ++counter + "]\n");
    }

//    @Around(value = "execution(* sayHello(..)) && this(bye)")
    public String addSay(ProceedingJoinPoint pjp, GoodBye bye) {
        String s;
        System.out.println("============= 前 ============");
        try {
            s = pjp.proceed() + bye.sayBye();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("============= 后 ============");
        return s;

    }

//    @DeclareParents(value = "com.randolflu.springframework03aop.aspectj2.*",
//            defaultImpl = DefaultGoodBye.class)
//    private GoodBye bye;
//    private int counter = 0;
//
//    @Before("execution(* say*(..)) && args(words)")
//    public void countSentence(StringBuffer words) {
//        words.append("[" + ++counter + "]\n");
//    }
//
//    @Around("execution(* sayHello(..)) && this(bye)")
//    public String addSay(ProceedingJoinPoint pjp, GoodBye bye) throws Throwable {
//        return pjp.proceed() + bye.sayBye();
//    }


    private int counter=0;
    public void reset() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }


    public void countSentence(StringBuffer words) {
        words.append("[" + ++counter + "]");
        System.out.println("countSentence()执行了");
    }

}
