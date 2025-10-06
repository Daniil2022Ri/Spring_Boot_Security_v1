package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface AdminService {
    void setRoleUser(boolean isAdmin);
    User findByUsername(String username);
    User save(User user);
    void deleteByUsername(String username);
    List<User> findAll();
    boolean existsByUsername(String username);
    void EditUser(User user);

}
