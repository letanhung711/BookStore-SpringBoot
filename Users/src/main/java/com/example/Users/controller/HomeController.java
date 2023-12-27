package com.example.Users.controller;

import com.example.Library.model.Product;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderDetailService orderDetailService;
    @GetMapping("/")
    public String home(Model model){
        //Top 10 san pham ban chay
        List<Product> topSellingProducts = orderDetailService.getTopSellingProducts();
        model.addAttribute("topSellingProducts", topSellingProducts);
        //Top 10 san pham moi nhat
        List<Product> topProducts = productRepository.findTop10ByOrderByCreateTimeDesc(PageRequest.of(0, 10));
        model.addAttribute("topProducts",topProducts);

        model.addAttribute("allProduct", productRepository.findAll());
        model.addAttribute("title","Mua Sách Online Nhanh Nhất Nhasach247");
        return "index";
    }
}
