package com.jethrojonson.serves.api.application.service;

import com.jethrojonson.serves.api.application.dto.CompanyDTO.*;
import com.jethrojonson.serves.api.application.dto.UserDTO;
import com.jethrojonson.serves.api.application.dto.UserDTO.*;
import com.jethrojonson.serves.api.domain.entities.Company;
import com.jethrojonson.serves.api.domain.entities.User;
import com.jethrojonson.serves.api.infrastructure.input.port.CompanyInputPort;
import com.jethrojonson.serves.api.infrastructure.output.port.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyUseCase implements CompanyInputPort {

    private final CompanyRepository companyRepository;

    @Override
    public CompanyResponse updateCompanyInfo(CompanyUpdateRequest toUpdate) {
        Company updated = (Company) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        updated.setCompanyName(toUpdate.companyName());
        updated.setCompanyAvatar(toUpdate.companyAvatar());
        return CompanyResponse.fromCompany(companyRepository.save(updated));
    }
}
