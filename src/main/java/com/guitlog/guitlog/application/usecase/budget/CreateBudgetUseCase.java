package com.guitlog.guitlog.application.usecase.budget;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.adapter.out.persistence.budget.BudgetEntity;
import com.guitlog.guitlog.adapter.out.persistence.budget.BudgetJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.budget.BudgetMapper;
import com.guitlog.guitlog.domain.model.budget.Budget;

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
