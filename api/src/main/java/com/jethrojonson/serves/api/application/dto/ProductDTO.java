package com.jethrojonson.serves.api.application.dto;

import com.jethrojonson.serves.api.application.dto.AllergenDTO.*;
import com.jethrojonson.serves.api.application.dto.CategoryDTO.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jethrojonson.serves.api.domain.entities.Company;
import com.jethrojonson.serves.api.domain.entities.Product;
import lombok.Builder;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface ProductDTO {

    public record NewProductRequest(
            @NotEmpty
            String productName
    ){

        public static Product toProduct(NewProductRequest p){
            return Product.builder()
                    .companyOwner(
                            (Company) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
                    )
                    .productName(p.productName)
                    .build();
        }
    }

    public record UpdateProductRequest(
            String productName,
            List<Long> categoriesIds,
            List<Long> allergensIds
    ){}

    @Builder
    public record ProductResponse(
            @JsonInclude(JsonInclude.Include.NON_NULL)
            Long id,
            String productName,
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            List<AllergenResponse> allergens,
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            List<CategoryResponse> categories
    ){

        public static ProductResponse fromProduct(Product p){
            return ProductResponse.builder()
                    .id(p.getId())
                    .productName(p.getProductName())
                    .allergens(
                            p.getAllergenList().stream().map(AllergenResponse::simpleFromAllergen).toList()
                    )
                    .categories(
                            p.getCategories().stream().map(CategoryResponse::fromCategory).toList()
                    )
                    .build();
        }

        public static ProductResponse simpleFromProduct(Product p){
            return ProductResponse.builder()
                    .productName(p.getProductName())
                    .build();
        }

        public static ProductResponse addedFromProduct(Product p){
            return ProductResponse.builder()
                    .id(p.getId())
                    .productName(p.getProductName())
                    .build();
        }
    }
}
