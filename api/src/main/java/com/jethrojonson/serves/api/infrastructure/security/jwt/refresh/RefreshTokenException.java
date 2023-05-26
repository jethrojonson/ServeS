package com.jethrojonson.serves.api.infrastructure.security.jwt.refresh;

import com.jethrojonson.serves.api.infrastructure.security.errorhandling.JwtTokenException;

public class RefreshTokenException extends JwtTokenException {

    public RefreshTokenException(String msg){
        super(msg);
    }
}
