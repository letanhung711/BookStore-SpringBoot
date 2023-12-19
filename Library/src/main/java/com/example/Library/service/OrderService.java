package com.example.Library.service;

import com.example.Library.dto.OrderDto;
import com.example.Library.model.Order;

public interface OrderService {
    String addOrder(OrderDto orderDto);
}
