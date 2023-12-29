package com.example.Users.controller;

import com.example.Library.dto.MailNewsDto;
import com.example.Library.model.EmailNews;
import com.example.Library.model.Product;
import com.example.Library.repository.ProductRepository;
import com.example.Library.service.EmailNewsService;
import com.example.Library.service.OrderDetailService;
import com.example.Library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private EmailNewsService emailNewsService;
    @GetMapping("/")
    public String home(Model model){
        //Top 10 san pham ban chay
        List<Product> topSellingProducts = orderDetailService.getTopSellingProducts();
        model.addAttribute("topSellingProducts", topSellingProducts);
        //Top 10 san pham moi nhat
        List<Product> topProducts = productRepository.findTop10ByOrderByCreateTimeDesc(PageRequest.of(0, 10));
        model.addAttribute("topProducts",topProducts);

        model.addAttribute("allProduct", productRepository.findAll());
        model.addAttribute("title","Mua Sách Online Nhanh Nhất Nhasach247");
        return "index";
    }

    @PostMapping("/pages/sendMailNews")
    public String addNews(@ModelAttribute MailNewsDto mailNewsDto){
        emailNewsService.addNew(mailNewsDto);
        return "redirect:/";
    }

    @GetMapping("/pages/search")
    public String showSearchSP(@RequestParam("search") String keywords, Model model){
        List<Product> products = productService.searchProduct(keywords);
        if(products.isEmpty()){
            model.addAttribute("message", "Không tìm thấy sản phẩm");
        }else {
            model.addAttribute("products",products);
        }
        model.addAttribute("title", keywords);
        return "/pages/danhmucsanpham";
    }
}
