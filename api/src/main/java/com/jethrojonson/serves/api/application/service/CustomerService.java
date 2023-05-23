package com.jethrojonson.serves.api.application.service;

import com.jethrojonson.serves.api.domain.entities.Customer;
import com.jethrojonson.serves.api.infrastructure.input.port.CustomerController;
import com.jethrojonson.serves.api.infrastructure.output.port.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerController {

    private final CustomerRepository customerRepository;

    @Override
    public String Saludotes() {
       return "HOLA MUNDO";
    }
}
