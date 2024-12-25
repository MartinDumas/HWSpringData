package com.example.TodoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/")
    public String enter() {
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login?error=true")
    public String loginError() {
        return "login";
    }

    @GetMapping("/login?logout=true")
    public String logout() {
        return "login";
    }
}
