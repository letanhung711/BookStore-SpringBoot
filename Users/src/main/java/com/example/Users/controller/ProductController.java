package com.example.Users.controller;

import com.example.Library.model.Product;
import com.example.Library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/{productId}")
    public String productInfo(@PathVariable Long productId, Model model){
        Optional<Product> productOptional = productService.getProductInformation(productId);
        if (productOptional.isEmpty()) {
            return "Not found product with this productId!";
        }
        Product product = productOptional.get();
        model.addAttribute("title", product.getName());
        model.addAttribute("product",product);
        return "productDetail";
    }
}
