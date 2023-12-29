package com.example.Library.service;

import com.example.Library.dto.ProductDto;
import com.example.Library.dto.ProductInfoDto;
import com.example.Library.model.Product;
import com.example.Library.model.ProductInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductInformation(long id);
    String addProduct(ProductDto productDto, ProductInfoDto productInfoDto, MultipartFile file) throws IOException;
    String updateProduct(long id, ProductDto productDto);
    String deleteProduct(long id);
    Optional<ProductInfo> getInfoOfProduct(long id);
    List<Product> searchProduct(String name);
}
