package com.jethrojonson.serves.api.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jethrojonson.serves.api.application.dto.ProductDTO.*;
import com.jethrojonson.serves.api.domain.entities.Category;
import com.jethrojonson.serves.api.domain.entities.Company;
import lombok.Builder;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public interface CategoryDTO {

    public record NewCategoryRequest(
            String categoryName
    ){

        public static Category toCategory(NewCategoryRequest c){
            return Category.builder()
                    .categoryName(c.categoryName)
                    .companyOwner(
                            (Company) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
                    )
                    .build();
        }

    }

    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record CategoryResponse(
            Long id,
            String categoryName,
            List<ProductResponse> products
    ){

        public static CategoryResponse fromCategory(Category c){
            return CategoryResponse.builder()
                    .id(c.getId())
                    .categoryName(c.getCategoryName())

                    .build();
        }

    }
}
