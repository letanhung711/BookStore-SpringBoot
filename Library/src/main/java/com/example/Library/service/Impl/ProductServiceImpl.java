package com.example.Library.service.Impl;

import com.example.Library.dto.ProductDto;
import com.example.Library.model.Product;
import com.example.Library.model.ProductInfo;
import com.example.Library.repository.ProductInfoRepository;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public Optional<Product> getProductInformation(long id) {
        return productRepository.findById(id);
    }

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
    public String updateProduct(long id, ProductDto productDto) {
        return null;
    }

    @Override
    public String deleteProduct(long id) {
        return null;
    }

    @Override
    public Optional<ProductInfo> getInfoOfProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(Product::getProductInfo);
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
