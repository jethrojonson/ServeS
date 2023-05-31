package com.jethrojonson.serves.api.application.exception;

import javax.persistence.EntityNotFoundException;

public interface ProductException {

    public class ProductNotFoundException extends EntityNotFoundException{
        public ProductNotFoundException (){
            super("The product could not be found");
        }
        public ProductNotFoundException(Long id){
            super(String.format("The product with ID (%s) does not exist", id));
        }
        public ProductNotFoundException(Long id, String companyName){
            super(String.format("The product with ID (%s) is not present in the company (%s)",id, companyName));
        }
    }
}
