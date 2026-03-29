package com.guitlog.guitlog.category.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

    @EntityGraph(attributePaths = {"user", "parentCategory"})
    Optional<CategoryEntity> findWithDetailsById(Long id);

    @EntityGraph(attributePaths = {"parentCategory"})
    List<CategoryEntity> findWithDetailsByUserId(Long userId);
}
