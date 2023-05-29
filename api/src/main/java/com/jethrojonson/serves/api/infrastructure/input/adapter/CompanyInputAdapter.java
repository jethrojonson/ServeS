package com.jethrojonson.serves.api.infrastructure.input.adapter;

import com.jethrojonson.serves.api.application.dto.CompanyDTO.*;
import com.jethrojonson.serves.api.application.dto.UserDTO.*;
import com.jethrojonson.serves.api.domain.entities.Company;
import com.jethrojonson.serves.api.domain.entities.User;
import com.jethrojonson.serves.api.infrastructure.input.port.CompanyInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyInputAdapter {

    private final CompanyInputPort companyInputPort;

    @PutMapping("/{username}")
    public CompanyResponse updateCompanyInfo (
            @PathVariable @AuthenticationPrincipal(expression = "username") String username,
            @RequestBody CompanyUpdateRequest toUpdate
    ){
        return companyInputPort.updateCompanyInfo(toUpdate);
    }



}
