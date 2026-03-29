package com.guitlog.guitlog.debt.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.debt.persistence.DebtEntity;
import com.guitlog.guitlog.debt.persistence.DebtJpaRepository;
import com.guitlog.guitlog.debt.persistence.DebtMapper;
import com.guitlog.guitlog.debt.domain.Debt;

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
