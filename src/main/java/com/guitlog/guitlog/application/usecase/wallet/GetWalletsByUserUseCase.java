package com.guitlog.guitlog.application.usecase.wallet;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.adapter.out.persistence.wallet.WalletEntity;
import com.guitlog.guitlog.adapter.out.persistence.wallet.WalletJpaRepository;

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
