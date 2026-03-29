package com.guitlog.guitlog.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.guitlog.guitlog.adapter.out.persistence.category.CategoryEntity;
import com.guitlog.guitlog.domain.model.budget.BudgetPeriod;

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
