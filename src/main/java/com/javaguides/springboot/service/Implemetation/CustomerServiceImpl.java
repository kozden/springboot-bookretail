package com.javaguides.springboot.service.Implemetation;

import com.javaguides.springboot.exception.UserNotFoundException;
import com.javaguides.springboot.model.Customer;
import com.javaguides.springboot.repository.CustomerRepository;
import com.javaguides.springboot.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        Customer hasCustomer = customerRepository.findByEmail(customer.getEmail());
        if(hasCustomer ==null){
            try {
                return customerRepository.save(customer);
            }
            catch (Exception e) {
                log.error(e.getMessage() + e);
            }
            return null;
        }else{
            return null;
        }
    }

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable) {
        try {
            return customerRepository.findAll(pageable);
        }
        catch (Exception e) {
            throw new UserNotFoundException("There is no user");
        }
    }
}
