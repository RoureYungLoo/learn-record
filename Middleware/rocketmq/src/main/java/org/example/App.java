package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static void main(String[] args) {
        //import org.apache.logging.log4j.LogManager;  Log4j2的日志管理器
        //import org.apache.logging.log4j.Logger;      Log4j2的日志记录器
        //通过日志管理器获取Logger对象
        Logger logger = LoggerFactory.getLogger(App.class);
        //打印日志
        logger.error(" 错误信息，不会影响系统运行");         //默认级别
        logger.warn(" 警告信息，可能会发生问题");
        logger.info(" 运行信息，数据连接，网络连接，IO操作等");
        logger.debug(" 调试信息，一般在开发中使用，记录程序变量传递信息等等");
        logger.trace(" 追踪信息，记录程序所有的流程信息");
    }
}
