package com.design_pattern.creational.singleton_pattern;

public class Client {
    public static void main(String[] args) {
        TaskManager manager = null;

        for (int i = 0; i < 10; i++) {
            manager = TaskManager.getInstance();
        }

        LoadBalancer lb1, lb2, lb3;
        lb1 = LoadBalancer.getLoadBalancer();
        lb2 = LoadBalancer.getLoadBalancer();
        lb3 = LoadBalancer.getLoadBalancer();
        if (lb1 == lb3 && lb2 == lb3 && lb1==lb2){
            System.out.println(true);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(lb1.getServer());
        }
    }
}
