package com.design_pattern.creational.prototype_pattern.three;

import javax.xml.transform.Source;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        WeeklyLog log1,log2;
        log1=new WeeklyLog();
        Attachment attachment = new Attachment();
        log1.setAttachment(attachment);
//        log2 = log1.clone(); // 浅克隆

        log2=log1.deepClone();
        System.out.println(log1==log2); // false
        System.out.println(log1.getAttachment()==log2.getAttachment()); //
    }
}
