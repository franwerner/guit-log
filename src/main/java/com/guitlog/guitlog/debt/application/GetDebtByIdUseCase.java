package com.guitlog.guitlog.debt.application;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.debt.persistence.DebtEntity;
import com.guitlog.guitlog.debt.persistence.DebtJpaRepository;

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
