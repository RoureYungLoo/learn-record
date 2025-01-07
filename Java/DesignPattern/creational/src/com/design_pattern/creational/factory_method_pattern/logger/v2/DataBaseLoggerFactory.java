package com.design_pattern.creational.factory_method_pattern.logger.v2;

public class DataBaseLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        System.out.println("create DB logger");
        return new DataBaseLogger();
    }

    @Override
    public Logger createLogger(String args) {
        System.out.println("create DB logger using args");
        return new DataBaseLogger();
    }

    @Override
    public Logger createLogger(Object obj) {
        System.out.println("create DB logger using object");
        return new DataBaseLogger();
    }
}
