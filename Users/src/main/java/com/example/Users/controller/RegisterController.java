package com.example.Users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("title","Đăng ký");
        return "register";
    }
}
