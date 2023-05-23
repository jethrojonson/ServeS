package com.jethrojonson.serves.api.domain.entities;

import com.jethrojonson.serves.api.domain.pk.ItemPk;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MENU")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item {

    @EmbeddedId
    private ItemPk id;

    @ManyToOne
    @MapsId("establishmentId")
    @JoinColumn(
            name = "establishment_id",
            foreignKey = @ForeignKey(name = "FK_MENU_TO_ESTABLISHMENTS")
    )
    private Establishment establishment;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(
            name = "product_id",
            foreignKey = @ForeignKey(name = "FK_MENU_TO_PRODUCTS")
    )
    private Product product;

    private String description;
    private double price;

}
