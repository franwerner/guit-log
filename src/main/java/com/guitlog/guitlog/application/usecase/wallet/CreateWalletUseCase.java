package com.guitlog.guitlog.application.usecase.wallet;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.adapter.out.persistence.wallet.WalletEntity;
import com.guitlog.guitlog.adapter.out.persistence.wallet.WalletJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.wallet.WalletMapper;
import com.guitlog.guitlog.domain.model.wallet.Wallet;

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
