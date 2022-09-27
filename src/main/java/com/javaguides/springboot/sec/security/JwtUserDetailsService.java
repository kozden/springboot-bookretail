package com.javaguides.springboot.sec.security;


import com.javaguides.springboot.sec.service.CusCustomer;
import com.javaguides.springboot.sec.service.entityservice.CusCustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final CusCustomerEntityService cusCustomerEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Long identityNo = Long.valueOf(username);

        CusCustomer cusCustomer = cusCustomerEntityService.findByIdentityNo(identityNo);

        return JwtUserDetails.create(cusCustomer);
    }

    public UserDetails loadUserByUserId(Long id) {

        CusCustomer cusCustomer = cusCustomerEntityService.findByIdentityNo(id);

        return JwtUserDetails.create(cusCustomer);
    }
}
