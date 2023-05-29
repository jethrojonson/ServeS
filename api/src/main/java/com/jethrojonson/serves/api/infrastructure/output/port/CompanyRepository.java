package com.jethrojonson.serves.api.infrastructure.output.port;

import com.jethrojonson.serves.api.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
