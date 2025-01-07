package com.design_pattern.creational.factory_method_pattern.logger.v2;

/* 抽象工厂 */
public interface LoggerFactory {
    public Logger createLogger();
    public Logger createLogger(String args);
    public Logger createLogger(Object obj);
}

/* 工厂方法隐藏 */
