package com.example.Library.service;

import com.example.Library.dto.UserDto;
import com.example.Library.model.Users;

import java.text.ParseException;

public interface UserService {
    Users findByAccount(String username, String password);
    Users addUser(UserDto userDto) throws ParseException;
    Users getEmailByUserName(String name);
    void deleteUser(long id);
}
