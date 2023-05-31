package com.jethrojonson.serves.api.infrastructure.input.port;

import com.jethrojonson.serves.api.application.dto.CategoryDTO.*;
import com.jethrojonson.serves.api.domain.entities.Category;

import java.util.List;

public interface CategoryInputPort {

    CategoryResponse addCategory(NewCategoryRequest toAdd);

    List<CategoryResponse> getAllCategories();


}
