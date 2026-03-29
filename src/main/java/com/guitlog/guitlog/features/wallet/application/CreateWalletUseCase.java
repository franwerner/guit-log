package com.guitlog.guitlog.features.wallet.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.wallet.persistence.WalletEntity;
import com.guitlog.guitlog.features.wallet.persistence.WalletJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateWalletUseCase {

    private final WalletJpaRepository walletJpaRepository;

    public WalletEntity execute(WalletEntity wallet) {
        return walletJpaRepository.save(wallet);
    }
}
