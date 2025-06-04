package com.xxx.structural.facade_pattern.two;

public class ClientTwo {
    public static void main(String[] args) throws Exception {
        EncryptFacade encryptFacade = new EncryptFacade();
        String src = "D:\\CodeSpace\\learn-record\\Java\\DesignPattern\\structural\\src\\com\\xxx\\structural\\facade_pattern\\two\\src.txt";
        String des = "D:\\CodeSpace\\learn-record\\Java\\DesignPattern\\structural\\src\\com\\xxx\\structural\\facade_pattern\\two\\des.txt";
//        encryptFacade.FileEncrypt(src, des);

        encryptFacade.FileDecrypt(des, src);
    }
}
