package com.guitlog.guitlog.application.usecase.debt;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.adapter.out.persistence.debt.DebtEntity;
import com.guitlog.guitlog.adapter.out.persistence.debt.DebtJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.debt.DebtMapper;
import com.guitlog.guitlog.domain.model.debt.Debt;

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
