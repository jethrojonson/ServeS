package com.jethrojonson.serves.api.domain.pk;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemPk implements Serializable {

    private Long establishmentId;
    private Long productId;

}
