package com.design_pattern.creational.prototype_pattern.four.doc;

public class Client {
    public static void main(String[] args) {
        PrototypeManager pm = PrototypeManager.getPrototypeManager();
        OfficialDocument doc1, doc2, doc3, doc4;
        doc1 = pm.getDoc("far");
        doc2 = pm.getDoc("far");
        doc3 = pm.getDoc("srs");
        doc4 = pm.getDoc("srs");

        doc1.display();
        doc2.display();
        System.out.println(doc1 == doc2);

        doc3.display();
        doc4.display();

        System.out.println(doc3 == doc4);
    }
}
