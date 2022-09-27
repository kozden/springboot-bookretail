package com.javaguides.springboot.service.Implemetation;

import com.javaguides.springboot.model.Book;
import com.javaguides.springboot.model.Bookorder;
import com.javaguides.springboot.repository.BookOrderRepository;
import com.javaguides.springboot.repository.BookRepository;
import com.javaguides.springboot.service.BookOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class BookOrderImpl implements BookOrderService {
    @Autowired
    private BookOrderRepository bookOrderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    BookServiceImpl bookService;
    @Override
    @Transactional
    public synchronized Bookorder addBookOrder(Bookorder bookorder) {
        Book book = bookRepository.findBookByName(bookorder.getBookname());
        if(book.getStock()<0 || book.getStock()<bookorder.getQuantity()){
            return null;
        }
        bookorder.setBookprice(book.getPrice());
        bookorder.setDate(new java.sql.Date(System.currentTimeMillis()).toString());

        Book updateBook = new Book();
        updateBook.setId(book.getId());
        updateBook.setStock(book.getStock()-bookorder.getQuantity());
        bookService.updateBookStock(updateBook);

        return bookOrderRepository.save(bookorder);
    }

    @Override
    public List<Bookorder> getBookorderByDate(String startedDate, String endedDate) {
        try {
            return bookOrderRepository.findBookorderByDateBetween(startedDate,endedDate);
        }
        catch (Exception e) {
            log.error(e.getMessage() + e);
        }
        return null;
    }


    @Override
    public List<Bookorder> findCustomerById(Long id) {
            try {
                return bookOrderRepository.findCustomerById(id);
            }
            catch (Exception e) {
                log.error(e.getMessage() + e);
                return null;
            }
    }
}
