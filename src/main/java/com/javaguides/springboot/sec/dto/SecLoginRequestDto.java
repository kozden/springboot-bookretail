package com.javaguides.springboot.sec.dto;

import lombok.Data;

@Data
public class SecLoginRequestDto {

    private Long identityNo;
    private String password;
}
