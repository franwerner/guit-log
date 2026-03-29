package com.guitlog.guitlog.application.usecase.debt;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.adapter.out.persistence.debt.DebtEntity;
import com.guitlog.guitlog.adapter.out.persistence.debt.DebtJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetDebtByIdUseCase {

    private final DebtJpaRepository debtJpaRepository;

    @Transactional(readOnly = true)
    public DebtEntity execute(Long id) {
        return debtJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Debt not found: " + id));
    }
}
