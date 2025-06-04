package com.xxx.structural.facade_pattern.two;

import java.io.FileInputStream;

public class FileReader {
    public String read(String filename) throws Exception {
        byte[] buf = new byte[100];
        FileInputStream fin = new FileInputStream(filename);
        int readCount = 0;
        StringBuilder sb = new StringBuilder();

        while ((readCount = fin.read(buf)) != -1) {
            sb.append(new String(buf, 0, readCount));
        }
        String s = sb.toString();
        fin.close();

        return s;
    }
}
