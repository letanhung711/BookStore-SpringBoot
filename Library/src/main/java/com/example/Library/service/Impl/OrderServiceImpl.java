package com.example.Library.service.Impl;

import com.example.Library.dto.CartItem;
import com.example.Library.dto.OrderDto;
import com.example.Library.model.Order;
import com.example.Library.model.Product;
import com.example.Library.repository.OrderDetailRepository;
import com.example.Library.repository.OrderRepository;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public String addOrder(OrderDto orderDto) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<Product> product = productRepository.findByName(orderDto.getTotalProduct());
        if(product == null || product.isEmpty()){
            return "Không có sản phẩm trong giỏ hàng";
        }

        Order order = new Order();
        order.setCreate_time(timestamp);
        order.setNameCustomer(orderDto.getNameCustomer());
        order.setPhone(orderDto.getPhone());
        order.setAddress(orderDto.getAddress());
        Order savedOrder = orderRepository.save(order);
        if (savedOrder != null) {
            return "Add order success";
        } else {
            return "Failed to add order";
        }
    }
}
