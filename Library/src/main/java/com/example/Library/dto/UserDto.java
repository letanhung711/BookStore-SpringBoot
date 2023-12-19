package com.example.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
public class UserDto {
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private Date birthdate;
    private String username;
    private String password;
    private String create_time;
}
