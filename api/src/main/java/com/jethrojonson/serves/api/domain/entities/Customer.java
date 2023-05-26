package com.jethrojonson.serves.api.domain.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(
        name = "customer_id",
        foreignKey = @ForeignKey(name = "FK_CUSTOMERS_USERS")
)
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

    @OneToMany(mappedBy = "customer")
    @Builder.Default
    private List<Order> ordersMade = new ArrayList<>();

    @OneToMany(mappedBy = "reviewer")
    @Builder.Default
    private List<Review> reviewsMade = new ArrayList<>();


}
