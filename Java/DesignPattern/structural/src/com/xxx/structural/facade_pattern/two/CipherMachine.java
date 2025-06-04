package com.xxx.structural.facade_pattern.two;

public class CipherMachine {
    public String encrypt(String plainText) {
        StringBuilder res = new StringBuilder();

        char[] charArray = plainText.toCharArray();

        for (char c : charArray) {
            c += 7;
            res.append(c);
        }
        return res.toString();
    }

    public String decrypt(String encryptText) {
        StringBuilder res = new StringBuilder();
        for (char c : encryptText.toCharArray()) {
            c -= 7;
            res.append(c);
        }
        return res.toString();
    }
}
