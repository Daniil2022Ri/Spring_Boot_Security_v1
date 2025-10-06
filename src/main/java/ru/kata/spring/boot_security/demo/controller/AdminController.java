package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.AdminService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping
    public String adminPage(Model model){
        model.addAttribute("users" , adminService.findAll());
        return "admin";
    }
    @GetMapping
    public void CreateNewUser(@ModelAttribute User user){
        adminService.save(user);
    }
    @PostMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        adminService.deleteByUsername(username);
        return "redirect:/admin";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        adminService.EditUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/role/{username}")
    public String toggleAdminRole(@PathVariable String username,
                                  @RequestParam boolean isAdmin) {
        return "redirect:/admin";
    }
}
