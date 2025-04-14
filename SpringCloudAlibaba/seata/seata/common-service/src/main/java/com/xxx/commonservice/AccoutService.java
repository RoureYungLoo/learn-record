package com.xxx.commonservice;

public interface AccoutService {
    void deduct(String commodityCode, int count);

    void batchDeduct(String commodityCode, int count);
}
