package com.javaguides.springboot.service.Implemetation;

import com.javaguides.springboot.model.Book;
import com.javaguides.springboot.repository.BookRepository;
import com.javaguides.springboot.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        if(book.getName()==null || book.getPrice().equals(null) || book.getStock()==null){
            return null;
        }else{
            try {
                return bookRepository.save(book);
            }
            catch (Exception e) {
                log.error(e.getMessage() + e);
            }
            return null;
        }
    }
    @Override
    public Book updateBookStock(Book book) {
        if(book.getId()==null || book.getStock()==null || book.getStock()<0 ){
            return null;
        }
        Book existingBook = bookRepository.findById(book.getId()).orElse(null);
        if(existingBook==null){
            return null;
        }
        existingBook.setStock(book.getStock());
        try {
            return bookRepository.save(existingBook);
        }
        catch (Exception e) {
            log.error(e.getMessage() + e);
        }
        return null;
    }

}
