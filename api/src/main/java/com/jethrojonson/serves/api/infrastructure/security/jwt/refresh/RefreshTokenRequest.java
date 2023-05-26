package com.jethrojonson.serves.api.infrastructure.security.jwt.refresh;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RefreshTokenRequest {

    private String refreshToken;

}
