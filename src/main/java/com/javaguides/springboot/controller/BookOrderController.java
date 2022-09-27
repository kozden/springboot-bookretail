package com.javaguides.springboot.controller;

import com.javaguides.springboot.model.Bookorder;
import com.javaguides.springboot.service.BookOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/bookorder")
public class BookOrderController {
    @Autowired
    private BookOrderService bookOrderService;

    @PostMapping("/add")
    public ResponseEntity<Bookorder> add(@RequestBody Bookorder bookorder) {
        log.info("BookOrder Add request is received");

        Bookorder result = bookOrderService.addBookOrder(bookorder);
        if(result==null){
            log.info("BookOrder Add request is unsuccessful");
            return new ResponseEntity("BookOrder Add request is unsuccessful ", HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            log.info("BookOrder Add request is unsuccessful");
            return new ResponseEntity(result, HttpStatus.OK);
        }
    }

    @GetMapping("/getorder/{id}")
    public ResponseEntity<List<Bookorder>> get(@PathVariable("id") Long id){
        log.info("BookOrder Get By Id request is received");

        List<Bookorder> result = bookOrderService.findCustomerById(id);
        if(result==null){
            log.info("BookOrder Get By Date is unsuccessful");
            return new ResponseEntity("BookOrder Get By Id request is unsuccessful ", HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            log.info("BookOrder Get By Id request is unsuccessful");
            return new ResponseEntity(result, HttpStatus.OK);
        }
    }

    @GetMapping("/getorderByDate/{startedDate}/{endedDate}")
    public ResponseEntity<List<Bookorder>> get(@PathVariable("startedDate") String startedDate, @PathVariable("startedDate") String endedDate){
        log.info("BookOrder Get By Date request is received");

        List<Bookorder> result = bookOrderService.getBookorderByDate(startedDate,endedDate);
        if(result==null){
            log.info("BookOrder Get By Date is unsuccessful");
            return new ResponseEntity("Book Add request is unsuccessful ", HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            log.info("BookOrder Get By Date is unsuccessful");
            return new ResponseEntity(result, HttpStatus.OK);
        }
    }
}
