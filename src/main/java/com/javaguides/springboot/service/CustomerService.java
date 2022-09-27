package com.javaguides.springboot.service;

import com.javaguides.springboot.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public Page<Customer> getAllCustomers(Pageable pageable);
}
