package com.guitlog.guitlog.features.wallet.application;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.wallet.persistence.WalletEntity;
import com.guitlog.guitlog.features.wallet.persistence.WalletJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetWalletsByUserUseCase {

    private final WalletJpaRepository walletJpaRepository;

    @Transactional(readOnly = true)
    public List<WalletEntity> execute(Long userId) {
        return walletJpaRepository.findByUserId(userId);
    }
}
