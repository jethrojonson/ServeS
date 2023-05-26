package com.jethrojonson.serves.api.application.service;

import com.jethrojonson.serves.api.application.dto.AllergenDTO.*;
import com.jethrojonson.serves.api.application.exception.AllergenException.*;
import com.jethrojonson.serves.api.infrastructure.input.port.AllergenInputPort;
import com.jethrojonson.serves.api.infrastructure.output.port.AllergenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AllergenUseCase implements AllergenInputPort {

    private final AllergenRepository allergenRepository;

    @Override
    public AllergenResponse addAllergen(NewAllergenRequest toAdd) {
        return AllergenResponse.fromAllergen(
                allergenRepository.save(
                        NewAllergenRequest.toAllergen(toAdd)
                )
        );
    }

    @Override
    public List<AllergenResponse> getAllAllergens() {
        if (allergenRepository.findAll().isEmpty())
            throw new EmptyAllergenListException();
        return allergenRepository.findAll().stream()
                .map(AllergenResponse::fromAllergen)
                .toList();
    }

    @Override
    public AllergenResponse getAllergenById(Long allergenId) {
        return allergenRepository.findById(allergenId)
                .map(AllergenResponse::fromAllergen)
                .orElseThrow(()-> new AllergenNotFoundException(allergenId));
    }

    @Override
    public AllergenResponse updateAllergen(Long allergenId, NewAllergenRequest toUpdate) {
        return allergenRepository.findById(allergenId)
                .map(allergen ->{
                    allergen.setAllergenName(toUpdate.allergenName());
                    allergen.setDescription(toUpdate.description());
                    return AllergenResponse.fromAllergen(allergenRepository.save(allergen));
                }).orElseThrow(()->new AllergenNotFoundException(allergenId));
    }

    @Override
    public void deleteAllergen(Long allergenId) {
        allergenRepository.findById(allergenId)
                .ifPresentOrElse(
                        allergenRepository::delete,
                        ()-> {throw new AllergenNotFoundException(allergenId);}
                );
    }


}
