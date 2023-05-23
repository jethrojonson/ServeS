package com.jethrojonson.serves.api.infrastructure.output.port;

import com.jethrojonson.serves.api.domain.entities.Customer;
import com.jethrojonson.serves.api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
