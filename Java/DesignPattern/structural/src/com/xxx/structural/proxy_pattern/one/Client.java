package com.xxx.structural.proxy_pattern.one;

public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy();

        subject.Request();
    }
}
