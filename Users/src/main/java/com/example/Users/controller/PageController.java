package com.example.Users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/payment")
    public String payment(@RequestParam(name = "totalAmount", defaultValue = "0") int totalAmount,
                          @RequestParam(name = "customerName", required = false) String customerName,
                          @RequestParam(name = "customerPhone", required = false) String customerPhone,
                          @RequestParam(name = "customerAddress", required = false) String customerAddress,
                          //@RequestParam(name = "MaDH", defaultValue = "") String madonhang,
                          Model model){
        model.addAttribute("title","Thanh toán");
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("customerName", customerName);
        model.addAttribute("customerPhone", customerPhone);
        model.addAttribute("customerAddress", customerAddress);
        //model.addAttribute("madonhang", madonhang);
        return "/pages/payment";
    }
}
