package com.xxx.storageservice.service.impl;

import com.xxx.storageservice.dao.StorageDao;
import com.xxx.storageservice.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;


    @Override
    public void decrease(Long productId, Integer count) {
        System.out.println("=== storage-service 开始扣减库存");
        storageDao.decrease(productId,count);
        System.out.println("=== storage-service 结束扣减库存");
    }
}
