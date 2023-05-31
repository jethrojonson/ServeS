package com.jethrojonson.serves.api.infrastructure.input.port;

import com.jethrojonson.serves.api.application.dto.ProductDTO.*;

import java.util.List;

public interface ProductInputPort {

    //COMPANY SIDE

    ProductResponse addProduct(NewProductRequest toAdd);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long productId, UpdateProductRequest toUpdate);

    //CUSTOMER SIDE


}
