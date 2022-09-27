package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaguides.springboot.controller.BookController;
import com.javaguides.springboot.model.Book;
import com.javaguides.springboot.service.BookService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    private static final String NAME = "Test Book";
    private static final int STOCK = 100;
    private static final BigDecimal PRICE = BigDecimal.valueOf(100.0);
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private BookService bookService;
    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setup()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @AfterEach
    public void afterTest()
    {
        verifyNoMoreInteractions(bookService);
    }

    @Test
    void add() throws Exception{
        Book book = new Book();
        book.setStock(STOCK);
        book.setName(NAME);
        book.setPrice(PRICE);
        Mockito.when(bookService.addBook(Mockito.any())).thenReturn(book);
        mockMvc.perform(post("/book/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(book))
                )
                .andExpect(status().isOk());
    }
}
