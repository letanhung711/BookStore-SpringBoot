package com.example.Library.service;

import com.example.Library.dto.ProductDto;
import com.example.Library.model.Product;
import com.example.Library.model.ProductInfo;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductInformation(long id);
    String addProduct(ProductDto productDto);
    String updateProduct(long id, ProductDto productDto);
    String deleteProduct(long id);
    Optional<ProductInfo> getInfoOfProduct(long id);
}
