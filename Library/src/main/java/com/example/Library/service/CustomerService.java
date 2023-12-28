package com.example.Library.service;

import com.example.Library.dto.CustomerDto;
import com.example.Library.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getCustomer(Long id);
    Customer addNewCustomer(CustomerDto customerDTO);
}
