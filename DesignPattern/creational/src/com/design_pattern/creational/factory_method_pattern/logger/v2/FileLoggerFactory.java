package com.design_pattern.creational.factory_method_pattern.logger.v2;

public class FileLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        System.out.println("create file logger");
        return new FileLogger();
    }

    @Override
    public Logger createLogger(String args) {
        System.out.println("create file logger using args");
        return new FileLogger();
    }

    @Override
    public Logger createLogger(Object obj) {
        System.out.println("create file logger using object");
        return new FileLogger();
    }
}
