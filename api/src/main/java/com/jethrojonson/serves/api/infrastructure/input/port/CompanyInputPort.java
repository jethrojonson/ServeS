package com.jethrojonson.serves.api.infrastructure.input.port;

import com.jethrojonson.serves.api.application.dto.CompanyDTO.*;
import com.jethrojonson.serves.api.application.dto.UserDTO.*;
import com.jethrojonson.serves.api.domain.entities.Company;

public interface CompanyInputPort {

    CompanyResponse updateCompanyInfo(CompanyUpdateRequest toUpdate);
}
