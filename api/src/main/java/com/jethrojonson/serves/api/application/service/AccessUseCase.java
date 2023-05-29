package com.jethrojonson.serves.api.application.service;
import com.jethrojonson.serves.api.application.dto.AccessDTO.*;
import com.jethrojonson.serves.api.application.dto.UserDTO.*;
import com.jethrojonson.serves.api.domain.entities.User;
import com.jethrojonson.serves.api.infrastructure.input.port.AccessInputPort;
import com.jethrojonson.serves.api.infrastructure.output.port.UserRepository;
import com.jethrojonson.serves.api.infrastructure.security.jwt.access.JwtProvider;
import com.jethrojonson.serves.api.infrastructure.security.jwt.refresh.RefreshToken;
import com.jethrojonson.serves.api.infrastructure.security.jwt.refresh.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccessUseCase implements AccessInputPort {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    public Optional<User> findByUsername(String username){
        return userRepository.findFirstByUsername(username);
    }

    public Optional<User> findById(UUID userId){
        return userRepository.findById(userId);
    }


    @Override
    public UserResponse signUp(SignUpRequest toAdd) {
        return toAdd.role().equals("CUSTOMER") ?
                UserResponse.fromCustomer(
                        userRepository.save(
                                SignUpRequest.toCustomer(toAdd, passwordEncoder)
                        )
                ) :
                UserResponse.fromCompany(
                        userRepository.save(
                                SignUpRequest.toCompany(toAdd, passwordEncoder)
                        )
                );
    }

    @Override
    public UserResponse login(LoginRequest loginRequest) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String token = jwtProvider.generateToken(authentication);
        User user = (User) authentication.getPrincipal();
        refreshTokenService.deleteByUser(user);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
        return UserResponse.fromLoginRequest(user, token, refreshToken.getToken());
    }
}
