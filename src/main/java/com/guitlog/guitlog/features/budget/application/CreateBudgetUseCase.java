package com.guitlog.guitlog.features.budget.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.budget.persistence.BudgetEntity;
import com.guitlog.guitlog.features.budget.persistence.BudgetJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateBudgetUseCase {

    private final BudgetJpaRepository budgetJpaRepository;

    public BudgetEntity execute(BudgetEntity budget) {
        return budgetJpaRepository.save(budget);
    }
}
