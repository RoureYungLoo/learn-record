package com.design_pattern.creational.prototype_pattern.three;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.file.StandardWatchEventKinds;

//public class WeeklyLog implements Cloneable { // 浅克隆
public class WeeklyLog implements Serializable { // 深克隆
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

//    @Override
//    protected WeeklyLog clone() throws CloneNotSupportedException {
//        Object obj = null;
//        obj = super.clone(); // 注意这里是浅拷贝
//        WeeklyLog w = (WeeklyLog) obj;
//        return w;
//    }


    protected WeeklyLog deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog) ois.readObject();
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
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
}
