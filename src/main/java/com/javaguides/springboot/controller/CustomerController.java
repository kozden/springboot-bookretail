package com.javaguides.springboot.controller;

import com.javaguides.springboot.model.Customer;
import com.javaguides.springboot.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomers")
    public ResponseEntity<Page<Customer>> getAllCustomers(@RequestParam Integer pageSize, @RequestParam Integer page){
        log.info("All customers list request is received");
        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Customer> costomerResult = customerService.getAllCustomers(pageable);
        if(costomerResult==null){
            log.info("New customer add request is unsuccessful");
            return new ResponseEntity("All customers list request is unsuccessful ",HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            log.info("All customers list request is successful");
            return new ResponseEntity(costomerResult, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> add(@RequestBody Customer customer){
        log.info("New customer add request is received");
        Customer customerResult = customerService.addCustomer(customer);
        if(customerResult ==null){
            log.info("New customer add request is unsuccessful");
            return new ResponseEntity("New customer add request is unsuccessful ",HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            log.info("New customer add request is successful");
            return new ResponseEntity(customerResult, HttpStatus.OK);
        }
    }
}
