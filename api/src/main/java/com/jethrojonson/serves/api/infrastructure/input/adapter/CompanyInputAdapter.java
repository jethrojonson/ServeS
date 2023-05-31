package com.jethrojonson.serves.api.infrastructure.input.adapter;

import com.jethrojonson.serves.api.application.dto.CategoryDTO.*;
import com.jethrojonson.serves.api.application.dto.CompanyDTO.*;
import com.jethrojonson.serves.api.application.dto.ProductDTO.*;
import com.jethrojonson.serves.api.infrastructure.input.port.AllergenInputPort;
import com.jethrojonson.serves.api.infrastructure.input.port.CategoryInputPort;
import com.jethrojonson.serves.api.infrastructure.input.port.CompanyInputPort;
import com.jethrojonson.serves.api.infrastructure.input.port.ProductInputPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.lang.annotation.Target;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@Tag(name = "Company Controller", description = "Controller of the companies operations")
public class CompanyInputAdapter {

    private final CompanyInputPort companyInputPort;
    private final ProductInputPort productInputPort;
    private final CategoryInputPort categoryInputPort;

    //COMPANY-SELF

    @PutMapping("/{username}")
    public CompanyResponse updateCompanyInfo(@RequestBody CompanyUpdateRequest toUpdate) {
        return companyInputPort.updateCompanyInfo(toUpdate);
    }

    //PRODUCTS

    @PostMapping("/{username}/products")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody NewProductRequest toAdd) {
        ProductResponse added = productInputPort.addProduct(toAdd);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{productId}")
                .buildAndExpand(added.id())
                .toUri();
        return ResponseEntity.created(uri).body(added);
    }

    @PutMapping("/{username}/products/{productId}")
    public ProductResponse updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequest toUpdate) {
        return productInputPort.updateProduct(productId, toUpdate);
    }

    @GetMapping("/{username}/products")
    public List<ProductResponse> getAllProducts() {
        return productInputPort.getAllProducts();
    }

    //CATEGORIES

    @PostMapping("/{username}/categories")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody NewCategoryRequest toAdd) {
        CategoryResponse added = categoryInputPort.addCategory(toAdd);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{categoryId}")
                .buildAndExpand(added.id())
                .toUri();
        return ResponseEntity.created(uri).body(added);
    }

    @GetMapping("/{username}/categories")
    public List<CategoryResponse> getAllCategories() {
        return categoryInputPort.getAllCategories();
    }


}
