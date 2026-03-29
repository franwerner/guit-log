package com.guitlog.guitlog.adapter.out.persistence.debt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtJpaRepository extends JpaRepository<DebtEntity, Long> {

    List<DebtEntity> findByUserId(Long userId);
}
