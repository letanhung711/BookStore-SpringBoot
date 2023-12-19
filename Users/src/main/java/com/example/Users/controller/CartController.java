package com.example.Users.controller;

import com.example.Library.dto.CartItem;
import com.example.Library.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping
    public String cart(Model model){
        List<CartItem> cartItems = cartService.getCartItems();
        System.out.println(cartItems);
        model.addAttribute("title","Giỏ hàng");
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }
    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId,
                            @RequestParam String productImgUrl,
                            @RequestParam String productName,
                            @RequestParam double productPrice,
                            @RequestParam int quantity, Model model) {
        cartService.addToCart(productId, productImgUrl, productName, productPrice, quantity);
        model.addAttribute("success", "Thêm sản phẩm vào giỏ hàng thành công.");
        return "redirect:/cart";
    }
    @GetMapping("/removeCartItem/{productId}")
    public String removeCartItem(@PathVariable Long productId) {
        cartService.removeCartItem(productId);
        return "redirect:/cart";
    }
}
