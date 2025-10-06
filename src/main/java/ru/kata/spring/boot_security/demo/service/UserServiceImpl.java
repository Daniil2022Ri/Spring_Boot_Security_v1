package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private final UserService userService;

    public UserServiceImpl(UserService userService){
        this.userService = userService;
    }

}
