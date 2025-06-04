package com.randolflu.springframework02ioc.datasource;

public class DataSourceTest implements DataSource {
    public DataSourceTest() {
        System.out.println(" 初始化 测试 数据库信息");
    }
}
