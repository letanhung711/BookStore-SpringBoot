package com.example.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class CartItem {
    private Long productId;
    private String productImgUrl;
    private String productName;
    private double price;
    private int quantity;
}
