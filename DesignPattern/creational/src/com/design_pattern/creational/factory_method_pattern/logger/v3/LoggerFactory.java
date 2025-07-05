package com.design_pattern.creational.factory_method_pattern.logger.v3;

public abstract class LoggerFactory {
    public abstract Logger createLogger();
    public void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }
}
