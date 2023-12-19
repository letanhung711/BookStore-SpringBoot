package com.example.Library.service.Impl;

import com.example.Library.dto.CartItem;
import com.example.Library.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private List<CartItem> cartItems = new ArrayList<>();
    @Override
    public void addToCart(Long productId, String productImgUrl, String productName, double price, int quantity) {
        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            // Nếu sản phẩm đã tồn tại, tăng số lượng
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            // Nếu sản phẩm chưa tồn tại, thêm vào giỏ hàng
            CartItem newItem = new CartItem();
            newItem.setProductId(productId);
            newItem.setProductImgUrl(productImgUrl);
            newItem.setProductName(productName);
            newItem.setPrice(price);
            newItem.setQuantity(quantity);
            cartItems.add(newItem);
        }
    }

    @Override
    public void removeCartItem(Long productId) {
        cartItems.removeIf(cartItem -> cartItem.getProductId().equals(productId));
    }

    @Autowired
    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
