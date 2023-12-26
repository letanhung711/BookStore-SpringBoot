package com.example.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductForm {
    private ProductDto productDto;
    private ProductInfoDto productInfoDto;
}
