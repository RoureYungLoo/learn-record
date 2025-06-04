package com.randolflu.springframework02ioc.lifecycle;


import org.springframework.context.Lifecycle;

//@Component
public class HelloLifeCycle implements Lifecycle {
    private boolean status = false;

    @Override
    public void start() {
        status = true;
        System.out.println("************************** call HelloLifeCycle -> start()");
    }

    @Override
    public void stop() {
        status = false;
        System.out.println("============================ call HelloLifeCycle -> stop()");
    }

    @Override
    public boolean isRunning() {
        return status;

    }

    public void hello() {
        System.out.println(status ? "容器没有关闭" : "容器已经关闭了");
    }
}
