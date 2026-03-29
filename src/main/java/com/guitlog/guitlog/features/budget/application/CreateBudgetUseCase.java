package com.guitlog.guitlog.features.budget.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.budget.persistence.BudgetEntity;
import com.guitlog.guitlog.features.budget.persistence.BudgetJpaRepository;
import com.guitlog.guitlog.features.budget.persistence.BudgetMapper;
import com.guitlog.guitlog.features.budget.domain.Budget;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateBudgetUseCase {

    private final BudgetJpaRepository budgetJpaRepository;
    private final BudgetMapper budgetMapper;

    public BudgetEntity execute(Budget budget) {
        return budgetJpaRepository.save(budgetMapper.toEntity(budget));
    }
}
