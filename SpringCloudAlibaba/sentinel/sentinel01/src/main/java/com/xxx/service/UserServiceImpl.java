package com.xxx.service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getOrderNo() {
        return String.valueOf(Timestamp.valueOf(LocalDateTime.now()));
    }
}
