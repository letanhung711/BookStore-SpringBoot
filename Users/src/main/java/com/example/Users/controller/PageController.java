package com.example.Users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class PageController {
    @GetMapping("/blog")
    public String showBlog(Model model){
        model.addAttribute("title","Blog");
        return "/pages/blog";
    }
    @GetMapping("/intro")
    public String showIntro(Model model){
        model.addAttribute("title","Giới thiệu");
        return "/pages/gioithieu";
    }
    @GetMapping("/contact")
    public String showContact(Model model){
        model.addAttribute("title","Liên hệ");
        return "/pages/lien-he";
    }
    @GetMapping("/payment-methods")
    public String showPayment(Model model){
        model.addAttribute("title","Phương thức thanh toán");
        return "/pages/payment-methods";
    }
}
