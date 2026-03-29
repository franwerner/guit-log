package com.guitlog.guitlog.domain.model.budget;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Budget {
    private Long id;
    private Long userId;
    private Long categoryId;
    private BigDecimal limitAmount;
    private BudgetPeriod period;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
}
