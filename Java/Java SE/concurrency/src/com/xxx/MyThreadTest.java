package com.xxx;

import java.util.concurrent.*;

//https://blog.csdn.net/weixin_43824267/article/details/112706385
//https://www.cnblogs.com/xichji/p/11630259.html
public class MyThreadTest {
    public static void main(String[] args) throws Exception {
        // thread1Test(args);
        // thread2Test(args);
        // thread3Test(args);
        // thread4Test(args);
        thread5Test(args);
    }

    private static void thread5Test(String[] args) {
        /* 使用匿名内部类 */
        // Runnable匿名类，实现其run()方法
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 任务代码
                System.out.println("子线程启动...");
                for (int i = 0; i < 50; i++) {
                    System.out.println("666 run i: " + i);

                }
            }
        });
        thread.start();

        // 使用lambda表达式函数式编程
        new Thread(() -> {
            System.out.println("子线程启动...");
            for (int i = 0; i < 50; i++) {
                System.out.println("777 run i: " + i);

            }
        },"我的线程").start();

        // Thread匿名类，重写Thread的run()方法
        new Thread(){
            @Override
            public void run() {
                System.out.println(getName() + " is running");
            }
        }.start();

//        new Thread()
    }

    private static void thread4Test(String[] args) {
        Thread4 th1 = new Thread4(); // Runnable实现类的对象
        Thread4_2 th1_2 = new Thread4_2(); // Callable实现类的对象


        ExecutorService service = Executors.newFixedThreadPool(20);

        System.out.println(service.getClass());

        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);
        service1.setKeepAliveTime(200, TimeUnit.SECONDS);


        /* execute() 方法适用于 Runnable 接口的实现类对象 */
        service.execute(th1);
        service.execute(th1);
        service.execute(th1);
        service.execute(th1); // 可以执行多次


        /* submit() 方法适用于 Callable 接口的实现类对象 */
        service.submit(th1_2);
        service.submit(th1_2);
        service.submit(th1_2);
        service.submit(th1_2);
        service.submit(th1_2);
        service.submit(th1_2);
        service.submit(th1_2);

        service.shutdown();
    }


    public static void thread1Test(String[] args) {
        Thread1 th1 = new Thread1();

        th1.start();

        // th1.run(); // 直接调用run()方法，并不能开启新线程

        // th1.start(); // 不能开启已经在运行的线程，会报错 IllegalThreadStateException

        Thread1 th2 = new Thread1();

        th2.start();


        /* main线程 */
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

    private static void thread2Test(String[] args) {
        Thread2 th = new Thread2();
        Thread th1 = new Thread(th);

        th1.setName("线程 " + th1.getId());

        // 开启线程
        th1.start();
        // th1.start(); // 重复 start() 会报错 IllegalThreadStateException

        Thread th2 = new Thread(th);

        th2.setName("线程 " + th2.getId());
        th2.start();
    }

    private static void thread3Test(String[] args) throws Exception {
        // 创建Callable接口实现类的对象
        Thread3 th = new Thread3();

        // 将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask<Integer>(th);

        // 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        Thread th1 = new Thread(futureTask, "thread-100");

        th1.start();
        // th1.start(); // 重复 start() 会报错 IllegalThreadStateException


//        try {
//            // 获取Callable中call方法的返回值
//            // get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
//            Object sum = futureTask.get();
//            System.out.println("--- sum = "+sum);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        // 创建 多个线程, Callable 里面的call() 方法只会执行一次，如果想要执行多次，需要创建多个 FutureTask 对象
        new Thread(futureTask, "thread-101").start();
        new Thread(futureTask, "thread-102").start();
        new Thread(futureTask, "thread-103").start();
        new Thread(futureTask, "thread-104").start();
        new Thread(futureTask, "thread-105").start();
        new Thread(futureTask, "thread-106").start();

        new Thread(new FutureTask<>(new Thread3())).start();
        new Thread(new FutureTask<>(new Thread3())).start();
        new Thread(new FutureTask<>(new Thread3())).start();


        int a = 100;
        int b = 0;
//        b = (int) futureTask.get();//要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致【堵塞】，直到计算完成
        //当futureTask完成后取值
        while (!futureTask.isDone()) {
            b = (int) futureTask.get();
        }
        System.out.println("Result=" + (a + b));

    }

}
