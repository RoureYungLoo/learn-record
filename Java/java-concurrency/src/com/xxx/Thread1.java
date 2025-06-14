package com.xxx;

/**【方式一 继承 Thread 类】
 * 1. 继承 Thread 类
 * 2. 重写 run() 方法
 * 3. 调用 start() 方法
 * */
public class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
/**
 * 问题1：直接调用 run() 方法不会创建线程
 *
 * 问题2：不能对已经在运行的线程调用 start() 方法
 */