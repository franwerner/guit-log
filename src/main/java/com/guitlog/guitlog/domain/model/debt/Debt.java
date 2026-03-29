package com.guitlog.guitlog.domain.model.debt;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Debt {
    private Long id;
    private Long userId;
    private BigDecimal initialAmount;
    private BigDecimal remainingAmount;
    private BigDecimal annualRate;
    private BigDecimal overdueRate;
    private LocalDate startDate;
    private LocalDate endDate;
    private DebtStatus status;
    private LocalDateTime createdAt;
}
