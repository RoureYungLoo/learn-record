package com.xxx.structural.facade_pattern.two;

public class EncryptFacade {
    private FileReader fileReader;
    private CipherMachine cipherMachine;
    private FileWriter fileWriter;

    public EncryptFacade() {
        fileReader = new FileReader();
        cipherMachine = new CipherMachine();
        fileWriter = new FileWriter();
    }

    /* 加密 */
    public void FileEncrypt(String src, String des) throws Exception {
        String plainText = fileReader.read(src);
        String encrypt = cipherMachine.encrypt(plainText);
        System.out.println("encrypt," + encrypt);
        fileWriter.write(encrypt, des);
    }

    /* 解密 */
    public void FileDecrypt(String src, String des) throws Exception {
        String encryptText = fileReader.read(src);
        String decryptText = cipherMachine.decrypt(encryptText);
        System.out.println("decryptText," + decryptText);

        fileWriter.write(decryptText, des);
    }
}
