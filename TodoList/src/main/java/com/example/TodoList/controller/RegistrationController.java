package com.example.TodoList.controller;

import com.example.TodoList.entity.User;
import com.example.TodoList.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.usernameExists(user.getUsername())) {
            model.addAttribute("error", "Username already exists.");
            return "/register";
        }

        userService.register(user);
        return "redirect:/login";
    }
}
