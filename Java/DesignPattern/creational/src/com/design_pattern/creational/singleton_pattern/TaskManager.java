package com.design_pattern.creational.singleton_pattern;

public class TaskManager {
    // 私有静态
    private static TaskManager tm = null;

    //    public TaskManager() {
    private TaskManager() {
        // 初始化窗口
        System.out.println("初始化窗口");
    }

    public void displayProcesses() {
        System.out.println("display processes");
    }

    public void displayServices() {
        System.out.println("display services");
    }

    // 公有静态, 供外部使用
    public static TaskManager getInstance() {
        if (tm == null) {
            tm = new TaskManager();
        }
        return tm;
    }

}