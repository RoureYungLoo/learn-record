package com.xxx.commonservice;

public interface StorageService {
    void deduct(String commodityCode, int count);

    void batchDeduct(String commodityCode, int count);
}
