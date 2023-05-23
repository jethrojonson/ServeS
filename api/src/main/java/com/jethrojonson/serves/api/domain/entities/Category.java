package com.jethrojonson.serves.api.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @ManyToMany
    @JoinTable(
            name = "PRODUCTS_CATEGORIES",
            joinColumns = @JoinColumn(
                    name = "category_id",
                    foreignKey = @ForeignKey(name = "FK_PRODUCTS_CATEGORIES_TO_CATEGORIES")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id",
                    foreignKey = @ForeignKey(name = "FK_PRODUCTS_CATEGORIES_TO_PRODUCTS")
            )
    )
    @Builder.Default
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            foreignKey = @ForeignKey(name = "FK_CATEGORIES_TO_COMPANIES")
    )
    private Company companyOwner;
}
