package com.javaguides.springboot.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.javaguides.springboot.dto.StaticsDto;
import com.javaguides.springboot.model.Bookorder;
import com.javaguides.springboot.service.Implemetation.StaticsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookretail")
public class Statics {
    @Autowired
    private StaticsServiceImpl staticsService;

    @GetMapping("/statics")
    public List<StaticsDto> getStatics(){
        return staticsService.getStatics();
    }
}
