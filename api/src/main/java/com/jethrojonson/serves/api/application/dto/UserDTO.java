package com.jethrojonson.serves.api.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jethrojonson.serves.api.domain.entities.Company;
import com.jethrojonson.serves.api.domain.entities.Customer;
import com.jethrojonson.serves.api.domain.entities.User;
import com.jethrojonson.serves.api.domain.enums.UserRoles;
import lombok.Builder;

import java.util.UUID;
import java.util.stream.Collectors;

public interface UserDTO {

    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record UserResponse(
            UUID id,
            String email,
            String username,
            String role,
            //IF CUSTOMER
            String name,
            String surname,
            String customerAvatar,
            //IF COMPANY
            String companyName,
            String cif,
            String companyAvatar,
            //IF LOGGED
            String token,
            String refreshToken
    ) {

        public static UserResponse fromCustomer(Customer c){
            return UserResponse.builder()
                    .id(c.getId())
                    .email(c.getEmail())
                    .username(c.getUsername())
                    .role(
                            c.getRoles().stream()
                                    .map(UserRoles::name)
                                    .collect(Collectors.joining(","))
                    )
                    .name(c.getName())
                    .surname(c.getSurname())
                    .customerAvatar(c.getCustomerAvatar())
                    .build();
        }

        public static UserResponse fromCompany(Company c){
            return UserResponse.builder()
                    .id(c.getId())
                    .email(c.getEmail())
                    .username(c.getUsername())
                    .role(
                            c.getRoles().stream()
                                    .map(UserRoles::name)
                                    .collect(Collectors.joining(","))
                    )
                    .companyName(c.getCompanyName())
                    .cif(c.getCif())
                    .companyAvatar(c.getCompanyAvatar())
                    .build();
        }

        public static UserResponse fromLoginRequest(User user, String token, String refreshToken){
            return UserResponse.builder()
                    .username(user.getUsername())
                    .role(
                            user.getRoles().stream()
                                    .map(UserRoles::name)
                                    .collect(Collectors.joining(","))
                    )
                    .token(token)
                    .refreshToken(refreshToken)
                    .build();
        }
    }
}
