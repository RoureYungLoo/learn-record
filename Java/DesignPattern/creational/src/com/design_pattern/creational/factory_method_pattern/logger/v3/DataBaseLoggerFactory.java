package com.design_pattern.creational.factory_method_pattern.logger.v3;

public class DataBaseLoggerFactory extends LoggerFactory{
    @Override
    public Logger createLogger() {
        System.out.println("create db logger");
        return new DataBaseLogger();
    }
}
