package com.javaguides.springboot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Status {
    private String status;
    private String errorMessage;
}
