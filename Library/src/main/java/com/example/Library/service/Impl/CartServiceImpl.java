package com.example.Library.service.Impl;

import com.example.Library.dto.CartItem;
import com.example.Library.model.Product;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductRepository productRepository;
    private List<CartItem> cartItems = new ArrayList<>();
    public boolean isCartCleared = false;
    @Override
    public void addToCart(long productId, String productImgUrl, String productName, double price, int quantity) {
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
    public void removeCartItem(long productId) {
        cartItems.removeIf(cartItem -> cartItem.getProductId().equals(productId));
    }

    @Override
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public void ClearList(){
        cartItems.clear();
        isCartCleared = true;
    }
    @Override
    public String Checkout(long id , int sold){
        if (!isCartCleared) {
            ClearList();
        }
        Optional<Product> p = productRepository.findById(id);
        if(p.isPresent()){
            Iterator<CartItem> iterator = cartItems.iterator();
            while (iterator.hasNext()) {
                CartItem cartItem = iterator.next();
                if (cartItem.getProductId().equals(p.get().getId())) {
                    iterator.remove(); // Sử dụng Iterator để loại bỏ an toàn phần tử hiện tại
                    break;
                }
            }
            CartItem cart_items = new CartItem();
            cart_items.setProductId(p.get().getId());
            cart_items.setProductName(p.get().getName());
            cart_items.setPrice(p.get().getPrice());
            cart_items.setQuantity(p.get().getQuantity());

            //số lượng sản phẩm hiện tại
            int quantity_present = p.get().getQuantity() - sold;
            if (sold > quantity_present){
                return "Sản phẩm " + cart_items.getProductName() +" đã hết hàng";
            }
            cart_items.setSold(sold);
            cart_items.setTotal(sold * cart_items.getPrice());
            cartItems.add(cart_items);
            System.out.println(cartItems);
            return null;
        }
        return null;
    }
}
