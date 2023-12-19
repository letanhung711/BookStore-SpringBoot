package com.example.Users.controller;

import com.example.Library.dto.OrderDto;
import com.example.Library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(){
//        orderService.addOrder(orderDto);
        return "redirect:/pages/payment";
    }
}
