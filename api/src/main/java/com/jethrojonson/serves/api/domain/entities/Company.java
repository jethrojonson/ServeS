package com.jethrojonson.serves.api.domain.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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


}
