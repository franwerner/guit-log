package com.guitlog.guitlog.application.usecase.wallet;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.adapter.out.persistence.wallet.WalletEntity;
import com.guitlog.guitlog.adapter.out.persistence.wallet.WalletJpaRepository;

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
