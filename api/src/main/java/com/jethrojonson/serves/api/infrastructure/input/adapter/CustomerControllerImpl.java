package com.jethrojonson.serves.api.infrastructure.input.adapter;

import com.jethrojonson.serves.api.infrastructure.input.port.CustomerController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerControllerImpl {

    private final CustomerController customerController;

    @GetMapping("/")
    public String saludasos(){
        return customerController.Saludotes();
    }

}
