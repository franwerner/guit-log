package com.guitlog.guitlog.application.usecase.budget;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.adapter.out.persistence.budget.BudgetJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.budget.BudgetMapper;
import com.guitlog.guitlog.application.dto.BudgetDetailDTO;

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
