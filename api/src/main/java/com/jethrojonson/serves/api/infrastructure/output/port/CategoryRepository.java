package com.jethrojonson.serves.api.infrastructure.output.port;

import com.jethrojonson.serves.api.domain.entities.Category;
import com.jethrojonson.serves.api.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAllByCompanyOwner(Company company);


}
