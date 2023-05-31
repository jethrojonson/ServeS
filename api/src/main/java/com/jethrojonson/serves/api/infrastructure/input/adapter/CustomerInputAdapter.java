package com.jethrojonson.serves.api.infrastructure.input.adapter;

import com.jethrojonson.serves.api.application.dto.CustomerDTO.*;
import com.jethrojonson.serves.api.infrastructure.input.port.CustomerInputPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Tag(name = "Customer Controller", description = "Controller of the customers operations")
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
