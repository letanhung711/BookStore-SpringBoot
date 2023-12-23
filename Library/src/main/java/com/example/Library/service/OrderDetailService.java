package com.example.Library.service;

import com.example.Library.model.Product;

import java.util.List;

public interface OrderDetailService {
    boolean newOrderDetail(long idOrder , long idProduct , int quantity ,double price);
    List<Product> getTopSellingProducts();
}
