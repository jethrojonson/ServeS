package com.jethrojonson.serves.api.application.exception;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public interface UserException {

    public class UserNotFoundException extends EntityNotFoundException{
        public UserNotFoundException(UUID userId){
            super(String.format("The user with username (%s) does not exist", userId));
        }
    }
}
