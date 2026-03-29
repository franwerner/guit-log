package com.guitlog.guitlog.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.guitlog.guitlog.adapter.out.persistence.debt.DebtEntity;

public record PaymentDetailDTO(
        Long id,
        Long userId,
        DebtEntity debt,
        BigDecimal amount,
        LocalDate paymentDate,
        BigDecimal inflationRate,
        BigDecimal realValue,
        LocalDateTime createdAt
) {}
