package com.jethrojonson.serves.api.domain.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(
        name = "company_id",
        foreignKey = @ForeignKey(name = "FK_COMPANIES_USERS"))
@Table(name = "COMPANIES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Company extends User{

    private String companyName;
    private String cif;
    private String companyAvatar;

    @OneToMany(mappedBy = "companyOwner")
    @Builder.Default
    private List<Product> productCatalog = new ArrayList<>();

    @OneToMany(mappedBy = "companyOwner")
    @Builder.Default
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "companyOwner")
    @Builder.Default
    private List<Establishment> establishments = new ArrayList<>();


}
