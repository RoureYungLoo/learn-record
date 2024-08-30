package com.randolflu.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class EncryptUtils {
    public static String MD5(String raw){
        String hex = DigestUtils.md5DigestAsHex((raw).getBytes());
        String uuid = UUID.randomUUID().toString();
        String digest = DigestUtils.md5DigestAsHex((hex+uuid).getBytes());
        return digest;
    }
}
