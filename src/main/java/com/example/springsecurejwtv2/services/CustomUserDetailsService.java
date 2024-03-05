package com.example.springsecurejwtv2.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // TODO: impl with real db repositories
        if (!userName.equals("Kelvin")) {
            throw new UsernameNotFoundException("Can not User with Name: " + userName);
        }
        return new User(
                "Kelvin",
                "020802",
                Collections.singleton(new SimpleGrantedAuthority("ADMIN"))
        );
    }

}
