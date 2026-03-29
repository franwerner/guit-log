package com.guitlog.guitlog.features.wallet.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {

    List<WalletEntity> findByUserId(Long userId);
}
