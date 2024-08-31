package com.randolflu;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void ThreadLocalTest(){
            ThreadLocal tl = new ThreadLocal<>();

            /*开启一个线程*/
            new Thread(()->{
                tl.set("username1");
                System.out.println(Thread.currentThread().getName() + tl.get());
                System.out.println(Thread.currentThread().getName() + tl.get());
                System.out.println(Thread.currentThread().getName() + tl.get());
            },"蓝色").start();

            new Thread(()->{
                tl.set("username2");
                System.out.println(Thread.currentThread().getName() + tl.get());
                System.out.println(Thread.currentThread().getName() + tl.get());
                System.out.println(Thread.currentThread().getName() + tl.get());
            },"红色").start();
    }
}
