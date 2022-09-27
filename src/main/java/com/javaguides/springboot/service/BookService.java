package com.javaguides.springboot.service;
import com.javaguides.springboot.model.Book;

public interface BookService {
    public Book addBook(Book book);
    public Book updateBookStock(Book book);

}
