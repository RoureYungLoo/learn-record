package com.xxx.structural.adapter_pattern.one;



public class Client {
    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.request();
    }
}
