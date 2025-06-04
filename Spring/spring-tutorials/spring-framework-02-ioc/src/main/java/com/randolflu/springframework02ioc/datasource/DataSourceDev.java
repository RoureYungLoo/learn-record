package com.randolflu.springframework02ioc.datasource;

public class DataSourceDev implements DataSource {
    public DataSourceDev() {
        System.out.println(" 初始化 开发环境 数据库信息");

    }
}
