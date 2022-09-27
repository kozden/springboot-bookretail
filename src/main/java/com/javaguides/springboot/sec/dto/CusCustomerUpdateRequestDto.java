package com.javaguides.springboot.sec.dto;

import lombok.Data;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
public class CusCustomerUpdateRequestDto {

    private Long id;
    private String name;
    private String surname;
    private Long identityNo;
    private String password;
}
