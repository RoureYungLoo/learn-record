package com.xxx.structural.facade_pattern.three;

public class NewCipherMachine {
    private int key = 7;

    public String encrypt(String plainText) {
        StringBuilder res = new StringBuilder();

        char[] charArray = plainText.toCharArray();
        char tmp;
        for (char c : charArray) {
            tmp = c;
            if (c >= 'a' && c <= 'z') {
                tmp += (char) (key % 26);
                if (tmp > 'z') tmp -= 26;
                if (tmp < 'a') tmp += 26;
            }
            if (c >= 'A' && c <= 'Z') {
                tmp += (char) (key % 26);
                if (tmp > 'Z') tmp -= 26;
                if (tmp < 'A') tmp += 26;
            }

            res.append(tmp);
        }
        return res.toString();
    }

    public String decrypt(String encryptText) {
        StringBuilder res = new StringBuilder();

        char[] charArray = encryptText.toCharArray();
        char tmp;
        for (char c : charArray) {
            tmp = c;
            if (c >= 'a' && c <= 'z') {
                tmp -= (char) (key % 26);
                if (tmp > 'z') tmp -= 26;
                if (tmp < 'a') tmp += 26;
            }
            if (c >= 'A' && c <= 'Z') {
                tmp -= (char) (key % 26);
                if (tmp > 'Z') tmp -= 26;
                if (tmp < 'A') tmp += 26;
            }

            res.append(tmp);
        }
        return res.toString();

    }

}
