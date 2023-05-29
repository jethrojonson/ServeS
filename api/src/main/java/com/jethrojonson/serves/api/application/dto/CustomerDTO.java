package com.jethrojonson.serves.api.application.dto;

import com.jethrojonson.serves.api.domain.entities.Customer;
import lombok.Builder;

public interface CustomerDTO {

    public record CustomerUpdateRequest(
            String name,
            String surname,
            String customerAvatar
    ) { }

    @Builder
    public record CustomerResponse(
            String customerUsername,
            String name,
            String surname,
            String customerAvatar
    ){

        public static CustomerResponse fromCustomer(Customer c){
            return CustomerResponse.builder()
                    .customerUsername(c.getUsername())
                    .name(c.getName())
                    .surname(c.getSurname())
                    .customerAvatar(c.getCustomerAvatar())
                    .build();
        }

    }
}
