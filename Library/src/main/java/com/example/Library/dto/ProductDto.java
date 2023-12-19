package com.example.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class ProductDto {
    private String name;
    private String author;
    private Double price;
    private Integer quantity;
    private String note;
    private String imageUrl;
    private String create_time;
    private String update_time;
}
