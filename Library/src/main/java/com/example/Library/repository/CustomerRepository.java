package com.example.Library.repository;

import com.example.Library.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsCustomerByNumberPhone(String numberphone);
    Customer findByNumberPhone(String numberphone);
}
