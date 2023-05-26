package com.jethrojonson.serves.api.application.exception;

import javax.persistence.EntityNotFoundException;

public interface AllergenException {

    public class AllergenNotFoundException extends EntityNotFoundException {
        public AllergenNotFoundException(){
            super("The allergen could not be found");
        }
        public AllergenNotFoundException(Long id){
            super(String.format("The allergen with ID (%s) does not exist", id));
        }
    }

    public class EmptyAllergenListException extends EntityNotFoundException{
        public EmptyAllergenListException(){
            super("No allergens were found with the search criteria");
        }
    }
}
