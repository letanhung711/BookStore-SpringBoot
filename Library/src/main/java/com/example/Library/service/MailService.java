package com.example.Library.service;

import com.example.Library.dto.CartItem;
import com.example.Library.model.Customer;
import com.example.Library.model.Order;

import java.util.List;

public interface MailService {
    String sendMail(Customer customer , Order order , List<CartItem> cartItem);
}
