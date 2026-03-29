package com.guitlog.guitlog.features.debt.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtJpaRepository extends JpaRepository<DebtEntity, Long> {

    List<DebtEntity> findByUserId(Long userId);
}
