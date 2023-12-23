package com.example.Library.service;

import com.example.Library.dto.CustomerDto;
import com.example.Library.model.Customer;

public interface CustomerService {
    Customer addNewCustomer(CustomerDto customerDTO);
}
