package com.example.Users.controller;

import com.example.Library.dto.CartItem;
import com.example.Library.dto.CustomerDto;
import com.example.Library.model.Customer;
import com.example.Library.model.Order;
import com.example.Library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class PageController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private MailService mailService;
    public Customer customerMail;
    public Order orderMail;

    @RequestMapping(value = "/pages/blog", method = RequestMethod.GET)
    public String showBlog(Model model){
        model.addAttribute("title","Blog");
        return "/pages/blog";
    }
    @RequestMapping(value = "/pages/intro", method = RequestMethod.GET)
    public String showIntro(Model model){
        model.addAttribute("title","Giới thiệu");
        return "/pages/gioithieu";
    }
    @RequestMapping(value = "/pages/contact", method = RequestMethod.GET)
    public String showContact(Model model){
        model.addAttribute("title","Liên hệ");
        return "/pages/lien-he";
    }
    @RequestMapping(value = "/pages/payment-methods", method = RequestMethod.GET)
    public String showPaymentMethod(Model model){
        model.addAttribute("title","Phương thức thanh toán");
        return "/pages/payment-methods";
    }
    @GetMapping("/pages/payments")
    public String Payment(@ModelAttribute CustomerDto customerDto , Model model){
        Customer customer = customerService.addNewCustomer(customerDto);
        Order order = orderService.addOrder(customer, "credit-card");

        int total_quantity = 0;
        double total_price = 0;
        List<CartItem> cartItems = cartService.getCartItems();
        for (CartItem cart : cartItems){
            orderDetailService.newOrderDetail(order.getId(), cart.getProductId() , cart.getSold() , cart.getTotal());
            total_quantity += cart.getSold();
            total_price += cart.getTotal();

        }
        Order orderUpdate = orderService.updateOrder(order.getId() , total_quantity , total_price);

        customerMail = customer;
        orderMail = orderUpdate;
        System.out.println("customerMail:"+customerMail);
        System.out.println("orderMail:"+orderMail);

        model.addAttribute("title","Thanh toán");
        model.addAttribute("customerDto" ,customerDto);

        // QR
        String imageUrl = "https://img.vietqr.io/image/TCB-19070550465018-compact2.png?amount="+total_price+"&addInfo=Thanh toán đơn hàng: "+order.getId()+"&accountName=LE TAN HUNG";
        model.addAttribute("imageUrl", imageUrl);

        //Thanh toán
        String orderId = order.getId()+"";
        String AMOUNT = total_price+"";
        String DESCRIPTION = "Thanh toán đơn hàng: " + order.getId();
        model.addAttribute("orderId", orderId);
        model.addAttribute("AMOUNT", AMOUNT);
        model.addAttribute("DESCRIPTION", DESCRIPTION);
        return "/pages/payment";
    }
    @GetMapping("/pages/submit")
    public String paymentSubmit(Model model) {
        //Gửi mail
        mailService.sendMail(customerMail,orderMail,cartService.getCartItems());
        //Update trạng thái order
        orderService.updateStatus(orderMail.getId());
        //Xóa giỏ hàng
        cartService.Clear();

        String notification = "Bạn vui lòng kiểm tra email để theo dõi đơn hàng";
        model.addAttribute("result_message", notification);
        return "redirect:/";
    }

}
