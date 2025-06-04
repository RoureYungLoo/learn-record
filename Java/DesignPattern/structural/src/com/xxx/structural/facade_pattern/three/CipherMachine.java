package com.xxx.structural.facade_pattern.three;

public class CipherMachine {
    private int key = 7;

    public String encrypt(String plainText) {
        StringBuilder res = new StringBuilder();

        char[] charArray = plainText.toCharArray();
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                c = (char) ((c + key) % 26);
            if (c >= '0' && c <= '9')
                c = (char) ((c + 5) % 10);

            res.append(c);
        }
        return res.toString();
    }

    public String decrypt(String encryptText) {
        StringBuilder res = new StringBuilder();
        for (char c : encryptText.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                c = (char) ((c - key) % 26);
            if (c >= '0' && c <= '9')
                c = (char) ((c - 5) % 10);
            res.append(c);
        }
        return res.toString();

    }

}
