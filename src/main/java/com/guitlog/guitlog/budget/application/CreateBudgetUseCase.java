package com.guitlog.guitlog.budget.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.budget.persistence.BudgetEntity;
import com.guitlog.guitlog.budget.persistence.BudgetJpaRepository;
import com.guitlog.guitlog.budget.persistence.BudgetMapper;
import com.guitlog.guitlog.budget.domain.Budget;

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
