package com.xxx.mybatisplus.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IAddressServiceTest {

    @Autowired
    private IAddressService iAddressService;

    @Test
    public void testLogicDelete(){
        iAddressService.removeById(2L);
        iAddressService.getById(2L);
    }
}