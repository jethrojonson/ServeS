package com.jethrojonson.serves.api;

import com.jethrojonson.serves.api.domain.entities.Customer;
import com.jethrojonson.serves.api.domain.entities.User;
import com.jethrojonson.serves.api.domain.enums.UserRoles;
import com.jethrojonson.serves.api.infrastructure.output.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MainFake {

    @PostConstruct
    void init() {}

}
