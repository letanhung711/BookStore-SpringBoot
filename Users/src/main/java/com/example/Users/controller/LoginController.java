package com.example.Users.controller;

import com.example.Library.dto.LoginRequest;
import com.example.Library.model.Users;
import com.example.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String showLogin(Model model){
        model.addAttribute("title","Đăng nhập");
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("loginRequest") LoginRequest loginRequest, Model model) {
        Users user = userService.findByAccount(loginRequest.getUsername(), loginRequest.getPassword());
        if(user != null){
            model.addAttribute("message","Đăng nhập thành công!");
            model.addAttribute("user",user);
        }
        return "redirect:/home";
    }
}
