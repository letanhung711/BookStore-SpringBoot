package com.example.Users.controller;

import com.example.Library.model.Product;
import com.example.Library.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/")
    public String home(Model model){
        List<Product> products = productRepository.findAll();
        List<Product> topProducts = productRepository.findTop10ByOrderByCreate_timeDesc();
        model.addAttribute("title","Mua Sách Online Nhanh Nhất Nhasach247");
        model.addAttribute("products",products);
        model.addAttribute("topProducts",topProducts);
        return "index";
    }
}
