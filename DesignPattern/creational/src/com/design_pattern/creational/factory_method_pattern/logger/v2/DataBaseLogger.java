package com.design_pattern.creational.factory_method_pattern.logger.v2;

public class DataBaseLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("write DB log");
    }
}
