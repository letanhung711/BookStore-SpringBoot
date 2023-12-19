package com.example.Library.service;

import com.example.Library.dto.ProductDto;
import com.example.Library.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductInformation(Long id);
    String addProduct(ProductDto productDto);
    String updateProduct(Long id, ProductDto productDto);
    String deleteProduct(Long id);
}
