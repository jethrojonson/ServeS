package com.jethrojonson.serves.api.application.service;

import com.jethrojonson.serves.api.application.dto.ProductDTO.*;
import com.jethrojonson.serves.api.domain.entities.Company;
import com.jethrojonson.serves.api.infrastructure.input.port.ProductInputPort;
import com.jethrojonson.serves.api.infrastructure.output.port.AllergenRepository;
import com.jethrojonson.serves.api.infrastructure.output.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductUseCase implements ProductInputPort {

    private final ProductRepository productRepository;
    private final AllergenRepository allergenRepository;

    @Override
    public ProductResponse addProduct(NewProductRequest toAdd) {
        return ProductResponse.addedFromProduct(
                productRepository.save(
                        NewProductRequest.toProduct(toAdd)
                )
        );
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        Company company = (Company) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return productRepository.findAllByCompanyOwner(company).stream()
                .map(ProductResponse::simpleFromProduct).toList();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Company company = (Company) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return null;
    }

    @Override
    public ProductResponse updateProduct(Long productId, UpdateProductRequest toUpdate) {

        return null;
    }


}
