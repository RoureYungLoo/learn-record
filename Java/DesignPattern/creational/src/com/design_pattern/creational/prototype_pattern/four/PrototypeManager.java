package com.design_pattern.creational.prototype_pattern.four;

import java.security.Key;
import java.util.Hashtable;

/* 原型管理器 */
public class PrototypeManager {
    private Hashtable<String, Prototype> prototypeTable;

    public Hashtable<String, Prototype> getPrototypeTable() {
        return prototypeTable;
    }

    public void setPrototypeTable(Hashtable<String, Prototype> prototypeTable) {
        this.prototypeTable = prototypeTable;
    }

    public void add(String key, Prototype prototype) {
        prototypeTable.put(key, prototype);
    }

    public Prototype get(String key) {
        return prototypeTable.get(key);
    }


}
