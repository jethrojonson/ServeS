package com.jethrojonson.serves.api.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ESTABLISHMENTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String establishmentName;
    private String address;
    private String telephone;
    private String description;


    @OneToMany(mappedBy = "establishment")
    @Builder.Default
    private List<Item> menu = new ArrayList<>();

    @OneToMany(mappedBy = "establishment")
    @Builder.Default
    private List<Order> ordersReceived = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            foreignKey = @ForeignKey(name = "FK_ESTABLISHMENTS_TO_COMPANIES")
    )
    private Company companyOwner;
}
