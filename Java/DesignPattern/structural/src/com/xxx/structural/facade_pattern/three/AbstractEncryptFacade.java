package com.xxx.structural.facade_pattern.three;

/* 抽象门面类型  抽象外观类 */
public abstract class AbstractEncryptFacade {
    public abstract void FileEncrypt(String src, String des) throws Exception;

    public abstract void FileDecrypt(String src, String des) throws Exception;
}
