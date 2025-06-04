package com.xxx.structural.facade_pattern.three;

public class Client3 {
    public static void main(String[] args) throws Exception {
        AbstractEncryptFacade abstractEncryptFacade = new NewEncryptFacade();

        String src = "D:\\CodeSpace\\learn-record\\Java\\DesignPattern\\structural\\" +
                "src\\com\\xxx\\structural\\facade_pattern\\three\\" +
                "plain.txt";
        String des = "D:\\CodeSpace\\learn-record\\Java\\DesignPattern\\structural\\" +
                "src\\com\\xxx\\structural\\facade_pattern\\three\\" +
                "encrypt.txt";

        NewCipherMachine cipherMachine = new NewCipherMachine();
        System.out.println(cipherMachine.encrypt("abc"));
        System.out.println(cipherMachine.decrypt("hij"));
    }
}
