package com.example.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderDto {
    private String nameCustomer;
    private String address;
    private String phone;
    private String totalProduct;
    private String note;
    private Timestamp bookingDate;
    private int quantity;
    private double price;
    private double totalPrice;
    private Timestamp create_time;
}
