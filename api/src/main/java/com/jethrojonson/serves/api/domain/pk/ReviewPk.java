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
public class ReviewPk implements Serializable {

    private UUID customerId;
    private Long establishmentId;
    private LocalDateTime reviewDate;

}
