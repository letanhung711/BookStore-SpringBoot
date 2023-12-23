package com.example.Users.controller;

import com.example.Library.model.Product;
import com.example.Library.model.ProductInfo;
import com.example.Library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/{productId}")
    public String productInfo(@PathVariable long productId, Model model){
        Optional<Product> productOptional = productService.getProductInformation(productId);
        if (productOptional.isEmpty()) {
            return "Not found product with this productId!";
        }
        Product product = productOptional.get();
        //Lấy trình trạng số lượng product
        if(product.getQuantity()>0){
            model.addAttribute("condition", "Còn hàng");
        }else {
            model.addAttribute("condition", "Hết hàng");
        }
        //Lấy thông tin chi tiết sản phẩm
        Optional<ProductInfo> productInfoOptional = productService.getInfoOfProduct(productId);
        if (productOptional.isEmpty()) {
            return "Not found productInfo with this productId!";
        }
        ProductInfo productInfo = productInfoOptional.get();

        model.addAttribute("title", product.getName());
        model.addAttribute("product",product);
        model.addAttribute("productInfo",productInfo);
        return "productDetail";
    }
}
