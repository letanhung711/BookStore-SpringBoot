package com.example.Users.controller;

import com.example.Library.dto.UserDto;
import com.example.Library.model.Users;
import com.example.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("title","Đăng ký");
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UserDto userDto, Model model) throws ParseException {
        List<Users> users = userService.findEmail(userDto.getEmail());
        if (users.isEmpty()){
            model.addAttribute("message","Đăng ký thành công");
            userService.addUser(userDto);
            return "register";
        }else {
            model.addAttribute("message","Email đã tồn tại");
            return "register";
        }
    }
}
