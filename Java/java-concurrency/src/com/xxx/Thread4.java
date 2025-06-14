package com.xxx;

import java.util.concurrent.Callable;

/**
 * 【方式四 使用线程池】
 * 1. 实现 Runnable / Callable 接口
 * 2. 重写 run() / call() 方法
 * 3. 创建 线程池
 * 4. 调用 execute() 方法执行线程 （参数是步骤 1中的实现类的对象）
 */
public class Thread4 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class Thread4_2 implements Callable {

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                sum += i;
            }
        }
        return sum;
    }
}