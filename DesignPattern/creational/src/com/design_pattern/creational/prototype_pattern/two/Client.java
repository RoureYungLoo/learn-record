package com.design_pattern.creational.prototype_pattern.two;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        WeeklyLog zhangsan = new WeeklyLog();
        zhangsan.setName("张三");
        zhangsan.setDate("第24周");
        zhangsan.setContent("这周工作很不错");
        System.out.println(zhangsan);

        WeeklyLog lisi = zhangsan.clone();
        lisi.setName("lisi");
        System.out.println(lisi);
    }
}
