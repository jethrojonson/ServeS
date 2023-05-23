package com.jethrojonson.serves.api.domain.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ALLERGENS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String allergenName;
    private String description;
}
