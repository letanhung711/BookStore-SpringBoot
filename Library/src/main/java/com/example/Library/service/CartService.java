package com.example.Library.service;

import com.example.Library.dto.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> getCartItems();
    void addToCart(long productId, String productImgUrl, String productName, double price, int quantity);
    void removeCartItem(long productId);
    String Checkout(long id , int sold);
    void ClearList();
    void Clear();
}
