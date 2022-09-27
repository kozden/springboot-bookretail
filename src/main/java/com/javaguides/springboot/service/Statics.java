package com.javaguides.springboot.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.javaguides.springboot.dto.StaticsDto;
import com.javaguides.springboot.model.Bookorder;

import java.lang.reflect.Array;
import java.util.List;

public interface Statics {
    public List<StaticsDto> getStatics();
}
