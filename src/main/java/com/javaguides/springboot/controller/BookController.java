package com.javaguides.springboot.controller;

import com.javaguides.springboot.model.Book;
import com.javaguides.springboot.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book){
        log.info("New Book Add request is received");

        Book bookResult = bookService.addBook(book);
        if(bookResult==null){
            log.info("Book Add request is unsuccessful");
            return new ResponseEntity("Book Add request is unsuccessful ",HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
           return new ResponseEntity(bookResult, HttpStatus.OK);
       }
    }

    @PutMapping("/update")
    ResponseEntity<Book> updateBook(@RequestBody Book newBook){
        log.info("Book Update request is received");
        Book bookResult = bookService.updateBookStock(newBook);
        if(bookResult==null){
            log.info("Book Update request is unsuccessful");
            return new ResponseEntity("Book Update request is unsuccessful ",HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            log.info("Book Update request is successful");
            return new ResponseEntity(bookResult, HttpStatus.OK);
        }
    }
}
