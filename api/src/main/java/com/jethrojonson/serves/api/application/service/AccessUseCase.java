package com.jethrojonson.serves.api.application.service;
import com.jethrojonson.serves.api.domain.entities.User;
import com.jethrojonson.serves.api.infrastructure.input.port.AccessInputPort;
import com.jethrojonson.serves.api.infrastructure.output.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccessUseCase implements AccessInputPort {

    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findFirstByUsername(username);
    }

    public Optional<User> findById(UUID userId){
        return userRepository.findById(userId);
    }


}
