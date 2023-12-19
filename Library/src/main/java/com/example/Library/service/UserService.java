package com.example.Library.service;

import com.example.Library.dto.UserDto;
import com.example.Library.model.Users;

public interface UserService {
    Users findByAccount(String username, String password);
    Users addUser(UserDto userDto);
}
