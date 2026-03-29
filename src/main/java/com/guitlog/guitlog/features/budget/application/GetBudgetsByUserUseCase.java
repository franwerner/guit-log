package com.guitlog.guitlog.features.budget.application;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.budget.persistence.BudgetJpaRepository;
import com.guitlog.guitlog.features.budget.persistence.BudgetMapper;
import com.guitlog.guitlog.features.budget.presentation.BudgetDetailDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetBudgetsByUserUseCase {

    private final BudgetJpaRepository budgetJpaRepository;
    private final BudgetMapper budgetMapper;

    @Transactional(readOnly = true)
    public List<BudgetDetailDTO> execute(Long userId) {
        return budgetJpaRepository.findWithDetailsByUserId(userId)
                .stream()
                .map(budgetMapper::toDetailDTO)
                .toList();
    }
}
