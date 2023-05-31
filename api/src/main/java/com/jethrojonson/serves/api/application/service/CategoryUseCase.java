package com.jethrojonson.serves.api.application.service;

import com.jethrojonson.serves.api.application.dto.CategoryDTO.*;
import com.jethrojonson.serves.api.application.dto.CompanyDTO;
import com.jethrojonson.serves.api.domain.entities.Category;
import com.jethrojonson.serves.api.domain.entities.Company;
import com.jethrojonson.serves.api.infrastructure.input.port.CategoryInputPort;
import com.jethrojonson.serves.api.infrastructure.output.port.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryUseCase implements CategoryInputPort {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse addCategory(NewCategoryRequest toAdd) {
        return CategoryResponse.fromCategory(
                categoryRepository.save(
                        NewCategoryRequest.toCategory(toAdd)
                )
        );
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        Company company = (Company) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return categoryRepository.findAllByCompanyOwner(company).stream()
                .map(CategoryResponse::fromCategory).toList();
    }


}
