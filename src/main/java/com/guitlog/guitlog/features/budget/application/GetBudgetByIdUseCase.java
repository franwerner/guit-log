package com.guitlog.guitlog.features.budget.application;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.budget.persistence.BudgetJpaRepository;
import com.guitlog.guitlog.features.budget.helper.BudgetMapper;
import com.guitlog.guitlog.features.budget.application.dto.BudgetDetailDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetBudgetByIdUseCase {

    private final BudgetJpaRepository budgetJpaRepository;
    private final BudgetMapper budgetMapper;

    @Transactional(readOnly = true)
    public BudgetDetailDTO execute(Long id) {
        return budgetJpaRepository.findWithDetailsById(id)
                .map(budgetMapper::toDetailDTO)
                .orElseThrow(() -> new RuntimeException("Budget not found: " + id));
    }
}
