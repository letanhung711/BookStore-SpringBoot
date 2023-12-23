package com.example.Library.service.Impl;

import com.example.Library.dto.CustomerDto;
import com.example.Library.model.Customer;
import com.example.Library.repository.CustomerRepository;
import com.example.Library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer addNewCustomer(CustomerDto customerDTO) {
        boolean exist_customer = customerRepository.existsCustomerByNumberPhone(customerDTO.getNumberPhone());
        if (!exist_customer){
            Customer customer = new Customer();
            customer.setFullName(customerDTO.getFullName());
            customer.setNumberPhone(customerDTO.getNumberPhone());
            customer.setAddress(customerDTO.getAddress());
            customer.setNote(customerDTO.getNote());
            customer.setEmail(customerDTO.getEmail());
            customerRepository.save(customer);
            return customer;
        }
        else {
            Customer customer = customerRepository.findByNumberPhone(customerDTO.getNumberPhone());
            customer.setNote(customer.getNote());
            customer.setAddress(customerDTO.getAddress());
            customerRepository.save(customer);
            return customer;
        }
    }
}
