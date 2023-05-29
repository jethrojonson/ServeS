package com.jethrojonson.serves.api.infrastructure.input.adapter;

import com.jethrojonson.serves.api.application.dto.AccessDTO.*;
import com.jethrojonson.serves.api.application.dto.UserDTO.*;
import com.jethrojonson.serves.api.infrastructure.input.port.AccessInputPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;

@RestController
@RequestMapping("/access")
@RequiredArgsConstructor
@Tag(name = "Access Controller", description = "Controller of the accessing operations")
public class AccessInputAdapter {

    private final AccessInputPort accessInputPort;
    private final AuthenticationManager authManager;


    @PostMapping("/signup")
    public ResponseEntity<UserResponse> singUp(@RequestBody SignUpRequest toAdd) {
        UserResponse added = accessInputPort.signUp(toAdd);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(added.id())
                .toUri();
        return ResponseEntity.created(uri).body(added);
    }

    @Transactional
    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.username(),
                                loginRequest.password()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return accessInputPort.login(loginRequest);
    }
}
