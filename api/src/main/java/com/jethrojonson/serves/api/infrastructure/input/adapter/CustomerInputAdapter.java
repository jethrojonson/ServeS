package com.jethrojonson.serves.api.infrastructure.input.adapter;

import com.jethrojonson.serves.api.application.dto.CustomerDTO.*;
import com.jethrojonson.serves.api.infrastructure.input.port.CustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerInputAdapter {

    private final CustomerInputPort customerInputPort;

    @PutMapping("/{username}")
    public CustomerResponse updateCustomerInfo(
            @PathVariable @AuthenticationPrincipal(expression = "username") String username,
            @RequestBody CustomerUpdateRequest toUpdate
    ){
        return customerInputPort.CustomerUpdateRequest(toUpdate);
    }
}
