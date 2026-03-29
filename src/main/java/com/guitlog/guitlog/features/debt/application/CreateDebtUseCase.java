package com.guitlog.guitlog.features.debt.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.debt.persistence.DebtEntity;
import com.guitlog.guitlog.features.debt.persistence.DebtJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateDebtUseCase {

    private final DebtJpaRepository debtJpaRepository;

    public DebtEntity execute(DebtEntity debt) {
        return debtJpaRepository.save(debt);
    }
}
