package com.guitlog.guitlog.features.debt.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.debt.persistence.DebtEntity;
import com.guitlog.guitlog.features.debt.persistence.DebtJpaRepository;
import com.guitlog.guitlog.features.debt.persistence.DebtMapper;
import com.guitlog.guitlog.features.debt.domain.Debt;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateDebtUseCase {

    private final DebtJpaRepository debtJpaRepository;
    private final DebtMapper debtMapper;

    public DebtEntity execute(Debt debt) {
        return debtJpaRepository.save(debtMapper.toEntity(debt));
    }
}
