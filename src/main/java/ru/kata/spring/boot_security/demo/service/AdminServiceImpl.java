package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public class AdminServiceImpl implements AdminService{

    private final AdminService adminService;
    public AdminServiceImpl(AdminService adminService){
        this.adminService = adminService;
    }

    @Override
    public User findByUsername(String username) {
        return adminService.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return adminService.save(user);
    }

    @Override
    public void deleteByUsername(String username) {
        adminService.deleteByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return adminService.findAll();
    }

    @Override
    public boolean existsByUsername(String username) {
        return adminService.existsByUsername(username);
    }

    @Override
    public void EditUser(User user) {
        adminService.EditUser(user);
    }


    @Override
    public void setRoleUser(boolean isAdmin) {
        adminService.setRoleUser(isAdmin);
    }
}
