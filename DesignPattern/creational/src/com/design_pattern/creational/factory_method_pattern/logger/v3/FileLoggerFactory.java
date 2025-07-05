package com.design_pattern.creational.factory_method_pattern.logger.v3;

public class FileLoggerFactory extends LoggerFactory{
    @Override
    public Logger createLogger() {
        System.out.println("create file logger");
        return new FileLogger();
    }
}
