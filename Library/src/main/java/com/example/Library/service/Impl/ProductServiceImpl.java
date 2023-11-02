package com.example.Library.service.Impl;

import com.example.Library.dto.ProductDto;
import com.example.Library.model.Product;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public String addProduct(ProductDto productDto) {
        Product product =new Product();
        product.setName(productDto.getName());
        product.setAuthor(productDto.getAuthor());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setNote(productDto.getNote());
        product.setImageUrl(productDto.getImageUrl());
        product.setCreate_time(convertToDate(productDto.getCreate_time()));
        product.setUpdate_time(convertToDate(productDto.getUpdate_time()));
        productRepository.save(product);
        return "Create product successful!!!";
    }

    @Override
    public String updateProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }

    public Timestamp convertToDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateObject = dateFormat.parse(date);
            Timestamp timestamp = new Timestamp(dateObject.getTime());
            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
