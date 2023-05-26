package com.jethrojonson.serves.api.application.dto;

import com.jethrojonson.serves.api.domain.enums.UserRoles;

import java.util.Set;

public interface AccessDTO {

    public record CreateCustomer(
            String email,
            String username,
            String password,
            String verifyPassword,
            Set<UserRoles> roles
    ){ }

    public record CreateCompany(
            String email,
            String username,
            String password,
            String verifyPassword,
            Set<UserRoles> roles
    ){ }
}
