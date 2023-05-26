package com.jethrojonson.serves.api.infrastructure.input.port;

import com.jethrojonson.serves.api.application.dto.AllergenDTO.*;

import java.util.List;

public interface AllergenInputPort {

    AllergenResponse addAllergen (NewAllergenRequest toAdd);

    List<AllergenResponse> getAllAllergens();

    AllergenResponse getAllergenById(Long allergenId);

    AllergenResponse updateAllergen(Long allergenId, NewAllergenRequest toUpdate);

    void deleteAllergen(Long allergenId);


}
