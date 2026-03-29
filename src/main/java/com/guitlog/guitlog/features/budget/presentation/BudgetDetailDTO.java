package com.guitlog.guitlog.features.budget.presentation;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.guitlog.guitlog.features.category.persistence.CategoryEntity;
import com.guitlog.guitlog.features.budget.domain.BudgetPeriod;

public record BudgetDetailDTO(
        Long id,
        Long userId,
        CategoryEntity category,
        BigDecimal limitAmount,
        BudgetPeriod period,
        LocalDate startDate,
        LocalDate endDate,
        boolean active
) {}
