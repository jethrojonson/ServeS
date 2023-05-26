package com.jethrojonson.serves.api.domain.entities;

import com.jethrojonson.serves.api.domain.pk.ReviewPk;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEWS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Review {

    @EmbeddedId
    private ReviewPk id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(
            name = "reviewer_id",
            foreignKey = @ForeignKey(name = "FK_REVIEWS_TO_CUSTOMERS"),
            columnDefinition = "uuid"
    )
    private Customer reviewer;

    @ManyToOne
    @MapsId("establishmentId")
    @JoinColumn(
            name = "establishment_id",
            foreignKey = @ForeignKey(name = "FK_REVIEWS_TO_ESTABLISHMENTS")
    )
    private Establishment target;

    private String review;
    private int score;

    private LocalDateTime responseDate;
    private String response;





}
