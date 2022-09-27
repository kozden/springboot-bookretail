package com.javaguides.springboot.sec.service.entityservice;

import com.javaguides.springboot.sec.dao.CusCustomerDao;
import com.javaguides.springboot.sec.service.CusCustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CusCustomerEntityService  {

    @Autowired
    private CusCustomerDao cusCustomerDao;

    public CusCustomer findByIdentityNo(Long id){
        Optional<CusCustomer> optionalCusCustomer = cusCustomerDao.findById(id);
        return optionalCusCustomer.isPresent()?optionalCusCustomer.get():null;
    }

    public CusCustomer save(CusCustomer c){
        return cusCustomerDao.save(c);
    }
}
