package com.example.Users.controller;

import com.example.Library.model.Product;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleData implements CommandLineRunner {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        addProduct();
    }
    private void addProduct(){
        if(!productRepository.existsByName("Bạn không thông minh lắm đâu")) {
            Product product = new Product();
            product.setName("Bạn không thông minh lắm đâu");
            product.setAuthor("David McRaney");
            product.setPrice(1000.0);
            product.setQuantity("10");
            product.setNote("");
            product.setCreate_time(productService.convertToDate("10/29/2023"));
            product.setUpdate_time(productService.convertToDate("10/29/2023"));
            productRepository.save(product);
        }
    }
}
