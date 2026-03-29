package com.guitlog.guitlog.features.wallet.application;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.wallet.persistence.WalletEntity;
import com.guitlog.guitlog.features.wallet.persistence.WalletJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetWalletByIdUseCase {

    private final WalletJpaRepository walletJpaRepository;

    @Transactional(readOnly = true)
    public WalletEntity execute(Long id) {
        return walletJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet not found: " + id));
    }
}
