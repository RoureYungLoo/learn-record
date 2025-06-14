package com.xxx;

/**【方式二 实现 Runnable 接口】
 *  1. 实现 Runnable 类
 *  2. 重写 run() 方法
 *  3. 创建 Thread 类
 *  4. 调用 start()方法
 */
public class Thread2 implements Runnable { //  Runnable 对象称为任务对象
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i );
            }
        }
    }
}
/*
开发中优先选择实现Runnable接口的方式
原因：
（1）实现的方式没有类的【单继承性】的局限性
（2）实现的方式更【适合来处理多个线程有共享数据】的情况
相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中
* */