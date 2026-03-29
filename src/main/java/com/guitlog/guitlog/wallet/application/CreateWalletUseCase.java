package com.guitlog.guitlog.wallet.application;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.wallet.persistence.WalletEntity;
import com.guitlog.guitlog.wallet.persistence.WalletJpaRepository;
import com.guitlog.guitlog.wallet.persistence.WalletMapper;
import com.guitlog.guitlog.wallet.domain.Wallet;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateWalletUseCase {

    private final WalletJpaRepository walletJpaRepository;
    private final WalletMapper walletMapper;

    public WalletEntity execute(Wallet wallet) {
        return walletJpaRepository.save(walletMapper.toEntity(wallet));
    }
}
