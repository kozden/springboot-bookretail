package com.javaguides.springboot.dto;

import java.math.BigDecimal;

public class StaticsDto {
    private Integer id;
    private Integer bookname;

    private BigDecimal quantity;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookname() {
        return bookname;
    }

    public void setBookname(Integer bookname) {
        this.bookname = bookname;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }


    public StaticsDto(String date, Integer id, Integer bookname, BigDecimal quantity) {
        this.date = date;
        this.id = id;
        this.bookname = bookname;
        this.quantity = quantity;
    }

    public StaticsDto(String date, Long id, Long bookname, BigDecimal quantity) {
        this.date = date;
        this.id = id.intValue();
        this.bookname = bookname.intValue();
        this.quantity = quantity;
    }




}
