package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    Optional<User> getUserByEmail(String email);
    User getUserByUserName(String email);
    boolean existsByEmail(String email);
    void addUser(User user);
}
