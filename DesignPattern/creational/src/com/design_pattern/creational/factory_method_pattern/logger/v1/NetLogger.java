package com.design_pattern.creational.factory_method_pattern.logger.v1;

public class NetLogger implements Logger {
    @Override
    public void writeLog() {
        /* 省略了复杂的网络连接操作 */
        System.out.println("write net log");

    }
}
