package com.jethrojonson.serves.api.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @ManyToMany
    @JoinTable(
            name = "PRODUCTS_CATEGORIES",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    foreignKey = @ForeignKey(name = "FK_PRODUCTS_CATEGORIES_TO_PRODUCTS")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id",
                    foreignKey = @ForeignKey(name = "FK_PRODUCTS_CATEGORIES_TO_CATEGORIES")
            )
    )
    @Builder.Default
    private List<Category> categories = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "PRODUCTS_ALLERGENS",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    foreignKey = @ForeignKey(name = "FK_PRODUCTS_ALLERGENS_TO_PRODUCTS")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "allergen_id",
                    foreignKey = @ForeignKey(name = "FK_PRODUCTS_ALLERGENS_TO_ALLERGENS")
            )
    )
    @Builder.Default
    private List<Allergen> allergenList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            foreignKey = @ForeignKey(name = "FK_PRODUCTS_TO_COMPANIES")
    )
    private Company companyOwner;

    @Builder.Default
    private boolean active = true;

    //HELPERS CATEGORIES//
    public void addCategories(List<Category> categoriesToAdd){
        categories.addAll(categoriesToAdd);
        categoriesToAdd.forEach(c->c.getProducts().add(this));
    }

    //HELPERS ALLERGENS//

}
