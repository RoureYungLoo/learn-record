package com.design_pattern.creational.factory_method_pattern.logger.v1;

public class FileLogger implements Logger{
    @Override
    public void writeLog() {
        /* 省略了复杂的文件IO操作 */
        System.out.println("write file log");
    }
}
