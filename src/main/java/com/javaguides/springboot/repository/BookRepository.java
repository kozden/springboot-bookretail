package com.javaguides.springboot.repository;

import com.javaguides.springboot.model.Book;
import com.javaguides.springboot.model.Bookorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findBookByName(String name);
}
