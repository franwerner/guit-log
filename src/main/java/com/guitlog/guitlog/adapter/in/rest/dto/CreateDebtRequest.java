package com.guitlog.guitlog.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateDebtRequest {
    private Long userId;
    private BigDecimal initialAmount;
    private BigDecimal annualRate;
    private BigDecimal overdueRate;
    private LocalDate startDate;
    private LocalDate endDate;
}
