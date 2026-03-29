package com.guitlog.guitlog.adapter.out.persistence.payment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {

    @EntityGraph(attributePaths = {"debt"})
    Optional<PaymentEntity> findWithDetailsById(Long id);

    @EntityGraph(attributePaths = {"debt"})
    List<PaymentEntity> findWithDetailsByDebtId(Long debtId);
}
