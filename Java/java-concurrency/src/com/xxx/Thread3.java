package com.xxx;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/** 【方式三 实现 Callable 接口】
 * 1. 实现 Callable 接口
 * 2. 重写 call() 方法
 * 3. 创建 FutureTask 对象 （callable实现类对象作为构造器参数）
 * 4. 创建 Thread 对象 （FutureTask对象作为构造器参数）
 * 5. 调用 start() 方法
 * 6. 获取 call() 方法的返回值
 */
public class Thread3 implements Callable {
    @Override
    //public Object call() throws Exception {
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(2500); // 睡眠500ms

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
        return sum;
    }
}
/*
实现Callable接口的方式创建线程的强大之处
    1. call()可以有返回值的
    2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
    3. Callable是支持泛型的
* */