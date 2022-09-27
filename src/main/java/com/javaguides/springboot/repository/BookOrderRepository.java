package com.javaguides.springboot.repository;

import com.javaguides.springboot.model.Bookorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookOrderRepository extends JpaRepository<Bookorder,Long> {
    List<Bookorder> findByCustomeremail(String email);
    List<Bookorder> findCustomerById(Long id);

    List<Bookorder> findBookorderByDateBetween(String startedDate, String endedDate);
}
