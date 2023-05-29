package com.jethrojonson.serves.api.application.service;

import com.jethrojonson.serves.api.application.dto.CustomerDTO.*;
import com.jethrojonson.serves.api.domain.entities.Customer;
import com.jethrojonson.serves.api.infrastructure.input.port.CustomerInputPort;
import com.jethrojonson.serves.api.infrastructure.output.port.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUseCase implements CustomerInputPort {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse CustomerUpdateRequest(CustomerUpdateRequest toUpdate) {
        Customer updated = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        updated.setName(toUpdate.name());
        updated.setSurname(toUpdate.surname());
        updated.setCustomerAvatar(toUpdate.customerAvatar());
        return CustomerResponse.fromCustomer(customerRepository.save(updated));
    }
}
