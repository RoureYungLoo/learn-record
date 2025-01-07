package com.design_pattern.creational.factory_method_pattern.logger;

//import com.design_pattern.creational.factory_method_pattern.logger.v2.*;

//import com.design_pattern.creational.factory_method_pattern.logger.v2.XMLUtils;
import com.design_pattern.creational.factory_method_pattern.logger.v3.LoggerFactory;
import com.design_pattern.creational.factory_method_pattern.logger.v3.XMLUtils;

public class Client {
    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger("n");
//        logger.writeLog();

//        LoggerFactory factory = new FileLoggerFactory(); //  这一步可以引入配置文件，消除new
//        Logger logger = factory.createLogger();
//        logger.writeLog();
//
//        factory= new NetLoggerFactory(); //  这一步可以引入配置文件，消除new
//        logger = factory.createLogger();
//        logger.writeLog();

//        LoggerFactory factory = (LoggerFactory)XMLUtils.gerBean();
////        Logger logger = factory.createLogger();
////        Logger logger = factory.createLogger("args");
//        Logger logger = factory.createLogger(new Object());
//        logger.writeLog();


        LoggerFactory factory = (LoggerFactory) XMLUtils.gerBean();
        factory.writeLog();
    }
}
