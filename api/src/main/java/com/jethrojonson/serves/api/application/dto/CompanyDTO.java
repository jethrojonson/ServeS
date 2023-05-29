package com.jethrojonson.serves.api.application.dto;

import com.jethrojonson.serves.api.domain.entities.Company;
import lombok.Builder;

public interface CompanyDTO {

    public record CompanyUpdateRequest(
            String companyName,
            String companyAvatar
    ){ }

    @Builder
    public record CompanyResponse(
            String companyOwner,
            String companyName,
            String cif,
            String companyAvatar
    ){

        public static CompanyResponse fromCompany(Company c){
            return CompanyResponse.builder()
                    .companyOwner(c.getUsername())
                    .companyName(c.getCompanyName())
                    .cif(c.getCif())
                    .companyAvatar(c.getCompanyAvatar())
                    .build();
        }
    }
}
