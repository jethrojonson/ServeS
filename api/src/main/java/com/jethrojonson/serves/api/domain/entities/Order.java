package com.jethrojonson.serves.api.domain.entities;

import com.jethrojonson.serves.api.domain.pk.OrderPk;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Order {

    @EmbeddedId
    private OrderPk id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(
            name = "customer_id",
            foreignKey = @ForeignKey(name = "FK_ORDERS_TO_CUSTOMERS")
    )
    private Customer customer;

    @ManyToOne
    @MapsId("establishmentId")
    @JoinColumn(
            name = "establishment_id",
            foreignKey = @ForeignKey(name = "FK_ORDERS_TO_ESTABLISHMENTS")
    )
    private Establishment establishment;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private List<Line> salesLines;

    private double totalPrice;
}
