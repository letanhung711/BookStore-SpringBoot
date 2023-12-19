package com.example.Library.service;

import com.example.Library.dto.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> getCartItems();
    void addToCart(Long productId, String productImgUrl, String productName, double price, int quantity);
    void removeCartItem(Long productId);
}
