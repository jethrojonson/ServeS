package com.jethrojonson.serves.api.domain.entities;

import com.jethrojonson.serves.api.domain.pk.LinePK;
import lombok.*;

import javax.persistence.*;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "SALES_LINES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Line {

    @EmbeddedId
    private LinePK id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumns(value = {
            @JoinColumn(
                    name = "order_customer",
                    referencedColumnName = "customer_id"
            ),
            @JoinColumn(
                    name = "order_establishment",
                    referencedColumnName = "establishment_id"
            ),
            @JoinColumn(
                    name = "order_date",
                    referencedColumnName = "order_date"
            )
        },
            foreignKey = @ForeignKey(name = "FK_SALES_LINES_TO_ORDERS")
    )
    private Order order;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(
                    name = "establishment_item",
                    referencedColumnName = "establishment_id"

            ),
            @JoinColumn(
                    name = "product_item",
                    referencedColumnName = "product_id"
            ),
    },
    foreignKey = @ForeignKey(name = "FK_SALES_LINES_TO_MENU")
    )
    private Item item;

    private int quantity;
    private double subTotal;

}
