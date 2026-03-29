package com.guitlog.guitlog.adapter.out.persistence.wallet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {

    List<WalletEntity> findByUserId(Long userId);
}
