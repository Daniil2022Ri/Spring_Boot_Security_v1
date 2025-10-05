package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = roleService.getRoleByName("ROLE_ADMIN")
                .orElseGet(() -> roleService.saveRole(new Role("ROLE_ADMIN")));

        Role userRole = roleService.getRoleByName("ROLE_USER")
                .orElseGet(() -> roleService.saveRole(new Role("ROLE_USER")));
/*
        if (!userService.existsByEmail("admin@mail.ru")) {
            User admin = new User();
            admin.setFirstName("Admin");
            admin.setLastName("Adminov");
            admin.setEmail("admin@mail.ru");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRoles(Set.of(adminRole, userRole));
            userService.addUser(admin);
        }

        if (!userService.existsByEmail("user@mail.ru")) {
            User user = new User();
            user.setFirstName("User");
            user.setLastName("Userov");
            user.setEmail("user@mail.ru");
            user.setPassword(passwordEncoder.encode("user"));
            user.setRoles(Set.of(userRole));
            userService.addUser(user);
        }

 */
    }

}
