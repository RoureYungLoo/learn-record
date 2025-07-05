package com.design_pattern.creational.factory_method_pattern.logger.v1;

/* 简单工厂模式（静态工厂模式） */
public class LoggerFactory {
    public static Logger getLogger(String args) {
        Logger LOGGER = null;
        switch (args) {
            case "f":
                LOGGER = new FileLogger();
                break;
            case "d":
                LOGGER = new DataBaseLogger();
                break;
            case "n":
                LOGGER = new NetLogger();
                break;
            default:
                throw new IllegalArgumentException("不支持的类型");
        }
        return LOGGER;
    }
}

/* v1 版本存在的问题：LoggerFactory不符合开闭原则 */