package com.design_pattern.creational.singleton_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
    private static LoadBalancer loadBalancer = null;

    private List<String> serverList = null;

    private LoadBalancer() {
        serverList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            serverList.add("10.10.10.1" + i);
        }
    }

    public static LoadBalancer getLoadBalancer() {
        if (loadBalancer == null) {
            loadBalancer = new LoadBalancer();
        }
        return loadBalancer;
    }

    public void addServer(String server) {
        serverList.add(server);
    }

    public void removeServer(String server) {
        serverList.remove(server);
    }

    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return serverList.get(i);
    }


}
