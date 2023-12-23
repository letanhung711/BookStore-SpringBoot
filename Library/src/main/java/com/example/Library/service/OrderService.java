package com.example.Library.service;

import com.example.Library.model.Customer;
import com.example.Library.model.Order;

public interface OrderService {
    Order addOrder(Customer customer, String paymentMethod);
    Order updateOrder(long id , int total_quantity , double total_price);

    Order updateStatus(long id);
}
