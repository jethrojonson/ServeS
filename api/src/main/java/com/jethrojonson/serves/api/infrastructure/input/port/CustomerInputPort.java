package com.jethrojonson.serves.api.infrastructure.input.port;

import com.jethrojonson.serves.api.application.dto.CustomerDTO.*;

public interface CustomerInputPort {

    CustomerResponse CustomerUpdateRequest (CustomerUpdateRequest toUpdate);
}
