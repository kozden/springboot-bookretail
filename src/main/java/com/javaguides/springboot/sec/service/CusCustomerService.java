package com.javaguides.springboot.sec.service;

import com.javaguides.springboot.sec.service.entityservice.CusCustomerEntityService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class CusCustomerService {

    private final CusCustomerEntityService cusCustomerEntityService;
    private final PasswordEncoder passwordEncoder;


    public CusCustomer save(CusCustomer cusCustomer) {


        String password = passwordEncoder.encode(cusCustomer.getPassword());
        cusCustomer.setPassword(password);

        cusCustomer = cusCustomerEntityService.save(cusCustomer);


        return cusCustomer;
    }


}
