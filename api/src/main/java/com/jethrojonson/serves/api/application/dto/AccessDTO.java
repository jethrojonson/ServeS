package com.jethrojonson.serves.api.application.dto;

import com.jethrojonson.serves.api.domain.entities.Company;
import com.jethrojonson.serves.api.domain.entities.Customer;
import com.jethrojonson.serves.api.domain.enums.UserRoles;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

public interface AccessDTO {

    public record SignUpRequest(
            String email,
            String username,
            String password,
            String verifyPassword,
            String role,
            //IF CUSTOMER
            String name,
            String surname,
            String customerAvatar,
            //IF COMPANY
            String companyName,
            String cif,
            String companyAvatar
            ) {

        public static Customer toCustomer(SignUpRequest u, PasswordEncoder passwordEncoder) {
            return Customer.builder()
                    .email(u.email)
                    .username(u.username)
                    .password(passwordEncoder.encode(u.password))
                    .roles(Set.of(UserRoles.CUSTOMER))
                    .name(u.name)
                    .surname(u.surname)
                    .customerAvatar(u.customerAvatar)
                    .build();
        }

        public static Company toCompany(SignUpRequest u, PasswordEncoder passwordEncoder) {
            return Company.builder()
                    .email(u.email)
                    .username(u.username)
                    .password(passwordEncoder.encode(u.password))
                    .roles(Set.of(UserRoles.COMPANY))
                    .companyName(u.companyName)
                    .cif(u.cif)
                    .companyAvatar(u.companyAvatar())
                    .build();
        }
    }

    public record LoginRequest(
            String username,
            String password
    ){}


}