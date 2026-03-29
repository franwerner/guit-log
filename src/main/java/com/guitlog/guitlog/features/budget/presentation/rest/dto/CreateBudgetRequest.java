package com.guitlog.guitlog.features.budget.presentation.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.guitlog.guitlog.features.budget.valueObjects.BudgetPeriod;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateBudgetRequest {
    private Long userId;
    private Long categoryId;
    private BigDecimal limitAmount;
    private BudgetPeriod period;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
}
