package com.design_pattern.creational.factory_method_pattern.logger.v2;

public class NetLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        System.out.println("create net logger");
        return new NetLogger();
    }

    @Override
    public Logger createLogger(String args) {
        System.out.println("create net logger using args");
        return new NetLogger();
    }

    @Override
    public Logger createLogger(Object obj) {
        System.out.println("create net logger using object");
        return new NetLogger();
    }
}
