package com.jethrojonson.serves.api.domain.pk;
import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LinePK implements Serializable {

    private int lineNumber;
    private OrderPk orderId;

}
