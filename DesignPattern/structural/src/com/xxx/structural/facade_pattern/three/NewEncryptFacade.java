package com.xxx.structural.facade_pattern.three;


public class NewEncryptFacade extends AbstractEncryptFacade {
    private FileReader fileReader;
    private NewCipherMachine newCipherMachine;
    private FileWriter fileWriter;

    public NewEncryptFacade() {
        fileReader = new FileReader();
        newCipherMachine = new NewCipherMachine();
        fileWriter = new FileWriter();
    }

    /* 加密 */
    public void FileEncrypt(String src, String des) throws Exception {
        String plainText = fileReader.read(src);
        String encrypt = newCipherMachine.encrypt(plainText);
        System.out.println("encrypt," + encrypt);
        fileWriter.write(encrypt, des);
    }

    /* 解密 */
    public void FileDecrypt(String src, String des) throws Exception {
        String encryptText = fileReader.read(src);
        String decryptText = newCipherMachine.decrypt(encryptText);
        System.out.println("decryptText," + decryptText);

        fileWriter.write(decryptText, des);
    }
}

