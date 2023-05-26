package com.jethrojonson.serves.api.infrastructure.security;

import com.jethrojonson.serves.api.application.service.AccessUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccessUseCase accessUseCase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accessUseCase.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("No user with username " + username));
    }
}
