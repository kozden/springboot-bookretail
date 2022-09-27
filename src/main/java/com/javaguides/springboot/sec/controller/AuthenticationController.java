package com.javaguides.springboot.sec.controller;


import com.javaguides.springboot.sec.dto.SecLoginRequestDto;
import com.javaguides.springboot.sec.service.AuthenticationService;
import com.javaguides.springboot.sec.service.CusCustomer;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(tags = "Authentication Controller")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto){

        String token = authenticationService.login(secLoginRequestDto);
        return new ResponseEntity(token, HttpStatus.OK);

    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody CusCustomer cusCustomer){

        return new ResponseEntity(authenticationService.register(cusCustomer),HttpStatus.OK);

    }
}
