package com.design_pattern.creational.prototype_pattern.four.doc;


import java.util.Hashtable;

public class PrototypeManager {
    /* 饿汉式单例模式 */
    private static PrototypeManager pm = new PrototypeManager();
    private Hashtable<String, OfficialDocument> hashtable = new Hashtable<>();

    private PrototypeManager() {
        hashtable.put("far", new FAR());
        hashtable.put("srs", new SRS());
    }

    public void addDoc(String key, OfficialDocument doc) {
        hashtable.put(key, doc);
    }

    /* 浅克隆 */
    public OfficialDocument getDoc(String key) {
        return (hashtable.get(key)).clone();
    }

    public static PrototypeManager getPrototypeManager() {
        return pm;
    }
}
