package com.example.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class ProductDto {
    private String name;
    private String author;
    private Double price;
    private String quantity;
    private String note;
    private String image;
    private String create_time;
    private String update_time;
}
