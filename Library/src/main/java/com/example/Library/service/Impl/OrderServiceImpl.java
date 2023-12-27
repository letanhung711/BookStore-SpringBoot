package com.example.Library.service.Impl;

import com.example.Library.model.*;
import com.example.Library.repository.OrderDetailRepository;
import com.example.Library.repository.OrderRepository;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Order addOrder(Customer customer, String paymentMethod) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Order order = new Order();
        order.setStatus(OrderStatus.CANCEL);
        order.setCreate_time(timestamp);
        if("cod".equals(paymentMethod)) {
            order.setPaymentMethods(PaymentMethods.COD);
        }else {
            order.setPaymentMethods(PaymentMethods.CREDIT_CARD);
        }
        order.setCustomer(customer);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order updateOrder(long id, int total_quantity, double total_price) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setTotalQuantity(total_quantity);
            order.setTotalPrice(total_price);
            orderRepository.save(order);
            return order;
        }
        return null;
    }

    @Override
    public Order updateStatus(long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(OrderStatus.CONFIRM);
            orderRepository.save(order);
            return order;
        }
        return null;
    }


}
