package com.guitlog.guitlog.adapter.out.persistence.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, Long> {


    @EntityGraph(attributePaths = {"category"})
    Optional<TransactionEntity> findWithDetailsById(Long id);

    @EntityGraph(attributePaths = {"category"})
    List<TransactionEntity> findWithDetailsByUserId(Long userId);
}
