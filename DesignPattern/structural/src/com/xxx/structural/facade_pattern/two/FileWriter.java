package com.xxx.structural.facade_pattern.two;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class FileWriter {
    public void write(String encryptText, String des) throws Exception {
        FileOutputStream fos = new FileOutputStream(des);
        byte[] bytes = encryptText.getBytes(StandardCharsets.UTF_8);
        int chunkSize = 4;

        for (int i = 0; i < bytes.length; i += chunkSize) {
            int endIndex = Math.min(i + chunkSize, bytes.length);
            int len = endIndex - i;
            fos.write(bytes, i, len);
            fos.flush();
            Thread.sleep(200);
        }

        fos.close();
    }
}
