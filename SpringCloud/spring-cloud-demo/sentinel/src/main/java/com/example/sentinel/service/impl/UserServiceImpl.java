package com.example.sentinel.service.impl;

import com.example.sentinel.repository.UserRepository;
import com.example.sentinel.domain.User;
import com.example.sentinel.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public boolean save(User users) {
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());
        userRepository.save(users);
        return true;
    }
}
