package com.design_pattern.creational.prototype_pattern.two;

public class WeeklyLog implements Cloneable {
    private String name;
    private String date;
    private String content;

    @Override
    protected WeeklyLog clone() throws CloneNotSupportedException {
//        return super.clone();
        Object obj = super.clone();
        WeeklyLog weeklyLog = (WeeklyLog) obj;
        return weeklyLog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "**** 周报 ****\n" +
                "姓名='" + name + '\'' +
                ", \n日期='" + date + '\'' +
                ", \n内容='" + content + '\'' +
                '}';
    }
}
