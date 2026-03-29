package com.guitlog.guitlog.adapter.out.persistence.budget;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetJpaRepository extends JpaRepository<BudgetEntity, Long> {

    @EntityGraph(attributePaths = {"category"})
    Optional<BudgetEntity> findWithDetailsById(Long id);

    @EntityGraph(attributePaths = {"category"})
    List<BudgetEntity> findWithDetailsByUserId(Long userId);
}
