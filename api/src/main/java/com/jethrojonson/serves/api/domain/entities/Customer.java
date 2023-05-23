package com.jethrojonson.serves.api.domain.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(
        name = "customer_id",
        foreignKey = @ForeignKey(name = "FK_CUSTOMERS_USERS"))
@Table(name = "CUSTOMERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Customer extends User{

    private String name;
    private String surname;
    private String customerAvatar;


}
