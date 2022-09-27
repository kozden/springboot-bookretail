package com.javaguides.springboot.service;

import com.javaguides.springboot.model.Bookorder;

import java.util.List;

public interface BookOrderService {
    public Bookorder addBookOrder(Bookorder bookorder);
    public List<Bookorder> getBookorderByDate(String startedDate, String endedDate);
    public List<Bookorder> findCustomerById(Long id);

}
