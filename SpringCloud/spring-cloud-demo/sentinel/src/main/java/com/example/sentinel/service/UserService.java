package com.example.sentinel.service;

import com.example.sentinel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    List<User> findAll();

    boolean save(User users);
}
