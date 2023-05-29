package com.jethrojonson.serves.api.infrastructure.input.port;

import com.jethrojonson.serves.api.application.dto.AccessDTO.*;
import com.jethrojonson.serves.api.application.dto.UserDTO.*;

public interface AccessInputPort {

    UserResponse signUp (SignUpRequest toAdd);

    UserResponse login (LoginRequest loginRequest);


}
