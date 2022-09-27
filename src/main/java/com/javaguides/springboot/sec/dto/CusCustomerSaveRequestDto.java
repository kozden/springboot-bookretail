package com.javaguides.springboot.sec.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
@Builder
public class CusCustomerSaveRequestDto {

    private String name;
    private String surname;
    private Long identityNo;
    private String password;
}
