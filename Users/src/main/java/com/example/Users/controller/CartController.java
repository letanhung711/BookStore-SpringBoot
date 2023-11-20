package com.example.Users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("title","Giỏ hàng");
        return "cart";
    }
}
