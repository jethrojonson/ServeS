package com.jethrojonson.serves.api.infrastructure.input.port;

import com.jethrojonson.serves.api.application.dto.AllergenDTO.*;

import java.util.List;

public interface AllergenInputPort {

    AllergenResponse addAllergen (AllergenRequest toAdd);

    List<AllergenResponse> getAllAllergens();

    AllergenResponse getAllergenById(Long allergenId);

    AllergenResponse updateAllergen(Long allergenId, AllergenRequest toUpdate);

    void deleteAllergen(Long allergenId);


}
