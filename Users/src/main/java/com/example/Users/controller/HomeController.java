package com.example.Users.controller;

import com.example.Library.model.Product;
import com.example.Library.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/")
    public String home(Model model){
        List<Product> products = productRepository.findAll();
        List<Product> topProducts = productRepository.findTop10ByOrderByCreateTimeDesc(PageRequest.of(0, 10));
        model.addAttribute("title","Mua Sách Online Nhanh Nhất Nhasach247");
        model.addAttribute("topProducts",topProducts);
        model.addAttribute("products",products);
        return "index";
    }
}
