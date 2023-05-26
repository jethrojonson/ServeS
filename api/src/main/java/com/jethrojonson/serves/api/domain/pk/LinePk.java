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
public class LinePk implements Serializable {

    private int lineNumber;
    private OrderPk orderId;

}
