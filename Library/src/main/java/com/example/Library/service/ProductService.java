package com.example.Library.service;

import com.example.Library.dto.ProductDto;

public interface ProductService {
    String addProduct(ProductDto productDto);
    String updateProduct(Long id, ProductDto productDto);
    String deleteProduct(Long id);
}
