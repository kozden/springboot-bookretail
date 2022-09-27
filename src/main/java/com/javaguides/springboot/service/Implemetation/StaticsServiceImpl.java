package com.javaguides.springboot.service.Implemetation;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.javaguides.springboot.dto.StaticsDto;
import com.javaguides.springboot.model.Bookorder;
import com.javaguides.springboot.repository.StaticsRepository;
import com.javaguides.springboot.service.Statics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class StaticsServiceImpl implements Statics {
    @Autowired
    private StaticsRepository staticsRepository;
    @Override
    public List<StaticsDto> getStatics() {

        return staticsRepository.getStatics();
    }
}
