package com.example.Users.controller;

import com.example.Library.dto.ProductForm;
import com.example.Library.dto.UserDto;
import com.example.Library.model.Users;
import com.example.Library.repository.*;
import com.example.Library.service.ProductService;
import com.example.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public void getAdmin(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Users users = userService.getEmailByUserName(username);
        model.addAttribute("name", users.getFullname());
    }
    @GetMapping("")
    public String showAdmin(Model model){
        getAdmin(model);
        return "/admin/index";
    }
    @GetMapping("/category/list_product")
    public String showListProduct(Model model){
        getAdmin(model);
        model.addAttribute("products", productRepository.findAll());
        return "/admin/category/list-product";
    }
    @GetMapping("/category/list_productdetail")
    public String showListProductDetail(Model model){
        getAdmin(model);
        model.addAttribute("productDetail", productInfoRepository.findAll());
        return "/admin/category/list-productdetail";
    }
    @GetMapping("/category/list_users")
    public String showListUsers(Model model){
        getAdmin(model);
        model.addAttribute("users", userRepository.findAll());
        return "/admin/category/list-users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admin/category/list_users";
    }
    @GetMapping("/category/list_order")
    public String showListOrders(Model model){
        getAdmin(model);
        model.addAttribute("orders", orderRepository.findAll());
        return "/admin/category/list-order";
    }
    @GetMapping("/category/list_orderdetail")
    public String showListOrderDetail(Model model){
        getAdmin(model);
        model.addAttribute("orderDetail", orderDetailRepository.findAll());
        return "/admin/category/list-orderdetail";
    }
    @GetMapping("/category/list_customer")
    public String showListCustomers(Model model){
        getAdmin(model);
        model.addAttribute("customers", customerRepository.findAll());
        return "/admin/category/list-customer";
    }
    @GetMapping("/category/add_user")
    public String showAddUser(Model model){
        getAdmin(model);
        model.addAttribute("user", new Users());
        return "/admin/category/add-user";
    }
    @PostMapping("/add_user")
    public String addUser(@ModelAttribute("user") UserDto userDto) throws ParseException {
        Users users = userService.addUser(userDto);
        if(users==null){
            return "redirect:/category/add_user";
        }
        return "redirect:/admin/category/list_users";
    }
    @GetMapping("/category/add_product")
    public String showAddProduct(Model model){
        getAdmin(model);
        model.addAttribute("productForm", new ProductForm());
        return "/admin/category/add-product";
    }
    @PostMapping("/add_product")
    public String addProduct(@ModelAttribute("productForm") ProductForm productForm,
                             @RequestParam("file") MultipartFile file) throws IOException {
        productService.addProduct(productForm.getProductDto(), productForm.getProductInfoDto(), file);
        return "redirect:/admin/category/list_product";
    }
    @GetMapping("/category/statistical")
    public String showStatistical(Model model){
        getAdmin(model);
        model.addAttribute("totalUser", userRepository.count());
        model.addAttribute("totalRevenue", orderRepository.getTotalPriceSum());
        return "/admin/category/statistical";
    }
}
