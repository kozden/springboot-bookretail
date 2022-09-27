package com.javaguides.springboot.sec.dao;

import com.javaguides.springboot.sec.service.CusCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CusCustomerDao extends JpaRepository<CusCustomer, Long> {


}
