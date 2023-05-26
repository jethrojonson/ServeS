package com.jethrojonson.serves.api.infrastructure.output.port;

import com.jethrojonson.serves.api.domain.entities.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergenRepository extends JpaRepository<Allergen, Long> {
}
