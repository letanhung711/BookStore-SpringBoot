package com.example.Users.controller;

import com.example.Library.dto.CustomerDto;
import com.example.Library.model.Customer;
import com.example.Library.repository.OrderRepository;
import com.example.Library.service.CartService;
import com.example.Library.service.CustomerService;
import com.example.Library.service.OrderService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(@RequestBody String dataToSend){
        String json = dataToSend;
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonArray data = jsonObject.getAsJsonArray("products");;
        for (JsonElement element : data) {
            JsonObject jsonObject1 = element.getAsJsonObject();
            long id = jsonObject1.get("productId").getAsLong();
            int sold = jsonObject1.get("quantity").getAsInt();

            String result_checkout = cartService.Checkout(id, sold);
            if (result_checkout != null)
                return "FAIL";
        }
        return "/pages/payment";
    }
}
