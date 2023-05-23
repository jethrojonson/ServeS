package com.jethrojonson.serves.api.domain.pk;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderPk implements Serializable {

    private UUID customerId;
    private Long establishmentId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;
}
