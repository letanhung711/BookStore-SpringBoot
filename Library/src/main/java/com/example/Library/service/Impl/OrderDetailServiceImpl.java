package com.example.Library.service.Impl;

import com.example.Library.model.Order;
import com.example.Library.model.OrderDetail;
import com.example.Library.model.Product;
import com.example.Library.repository.OrderDetailRepository;
import com.example.Library.repository.OrderRepository;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public boolean newOrderDetail(long idOrder, long idProduct, int quantity, double price) {
        Optional<Product> optionalProducts = productRepository.findById(idProduct);
        Optional<Order> optionalOrder = orderRepository.findById(idOrder);
        if(optionalProducts.isPresent() && optionalOrder.isPresent()){
            Product product = optionalProducts.get();
            Order order = optionalOrder.get();

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(quantity);
            orderDetail.setUnitPrice(price);
            orderDetailRepository.save(orderDetail);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getTopSellingProducts() {
        List<Object[]> topSellingProducts = orderDetailRepository.findTopSellingProducts(PageRequest.of(0, 10));
        // Chuyển đổi kết quả thành danh sách các đối tượng Product
        return topSellingProducts.stream().map(objects -> (Product) objects[0]).collect(Collectors.toList());
    }
}
