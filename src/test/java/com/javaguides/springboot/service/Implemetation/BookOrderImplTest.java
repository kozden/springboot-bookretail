package com.javaguides.springboot.service.Implemetation;

import com.javaguides.springboot.model.Book;
import com.javaguides.springboot.model.Bookorder;
import com.javaguides.springboot.repository.BookOrderRepository;
import com.javaguides.springboot.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class BookOrderImplTest {

    private static final String NAME = "Test Book";
    private static final int STOCK = 100;
    private static final BigDecimal PRICE = BigDecimal.valueOf(100.0);
    @Mock
    private BookRepository bookRepository;

    @Mock
    BookOrderRepository bookOrderRepository;

    @InjectMocks
    private BookOrderImpl bookOrderService;

    @Mock
    BookServiceImpl bookService;

    @Test
    void addBookOrder() {
        Bookorder bookorder = new Bookorder();
        bookorder.setBookname(NAME);
        bookorder.setId(20L);
        bookorder.setBookprice(BigDecimal.valueOf(150));
        Bookorder bookorder2 = new Bookorder();
        bookorder2.setBookname(NAME);
        bookorder.setId(20L);
        bookorder.setBookprice(BigDecimal.valueOf(150));
        Book book = new Book();
        book.setStock(STOCK);
        book.setName(NAME);
        book.setPrice(PRICE);
        Mockito.when(bookRepository.findBookByName(bookorder.getBookname())).thenReturn(book);
        Mockito.when(bookService.updateBookStock(Mockito.any())).thenReturn(book);
        Mockito.when(bookOrderRepository.save(Mockito.any())).thenReturn(bookorder);
        Bookorder c = bookOrderService.addBookOrder(bookorder2);
        Assertions.assertEquals(bookorder.getId(),c.getId());
        Mockito.verify(bookRepository).findBookByName(book.getName());
    }
}