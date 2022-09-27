package com.javaguides.springboot.repository;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.javaguides.springboot.dto.StaticsDto;
import com.javaguides.springboot.model.Bookorder;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StaticsRepository extends JpaRepository<Bookorder, Long> {
    @Query("select new com.javaguides.springboot.dto.StaticsDto(SUBSTRING(o.date,6,2), count(o.id), count(DISTINCT o.bookname), SUM(o.quantity*o.bookprice) ) "+
            "from Bookorder o  group by  o.date")
    List<StaticsDto> getStatics();
}
