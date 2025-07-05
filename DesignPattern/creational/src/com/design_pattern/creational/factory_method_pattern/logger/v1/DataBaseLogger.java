package com.design_pattern.creational.factory_method_pattern.logger.v1;

public class DataBaseLogger implements Logger{
    @Override
    public void writeLog() {
        /* 省略了复杂的数据库连接操作 */
        System.out.println("write db log");

    }
}
