package com.javaguides.springboot.sec.service;


import com.javaguides.springboot.sec.dto.SecLoginRequestDto;
import com.javaguides.springboot.sec.enums.EnumJwtConstant;
import com.javaguides.springboot.sec.security.JwtTokenGenerator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private CusCustomerService cusCustomerService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    public CusCustomer register(CusCustomer cusCustomer) {

        return cusCustomerService.save(cusCustomer);
    }

    public String login(SecLoginRequestDto secLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(secLoginRequestDto.getIdentityNo().toString(), secLoginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String bearer = EnumJwtConstant.BEARER.getConstant();

        return bearer + token;
    }


}
