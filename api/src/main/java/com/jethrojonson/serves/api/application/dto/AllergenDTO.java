package com.jethrojonson.serves.api.application.dto;

import com.jethrojonson.serves.api.domain.entities.Allergen;
import lombok.Builder;

import javax.validation.constraints.NotEmpty;

public interface AllergenDTO {

    public record NewAllergenRequest(
            @NotEmpty
            String allergenName,
            @NotEmpty
            String description
    ){
        public static Allergen toAllergen(NewAllergenRequest a){
            return Allergen.builder()
                    .allergenName(a.allergenName)
                    .description(a.description)
                    .build();
        }
    }

    @Builder
    public record AllergenResponse(
            Long id,
            String allergenName,
            String description
    ){
        public static AllergenResponse fromAllergen(Allergen a){
            return AllergenResponse.builder()
                    .id(a.getId())
                    .allergenName(a.getAllergenName())
                    .description(a.getDescription())
                    .build();
        }
    }

}
