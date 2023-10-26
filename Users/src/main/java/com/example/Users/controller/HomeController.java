package com.example.Users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Mua Sách Online Nhanh Nhất Nhasach247");
        return "index";
    }
    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("title","Giỏ hàng");
        return "cart";
    }
}
