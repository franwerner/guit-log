package com.guitlog.guitlog.features.payment.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.guitlog.guitlog.features.debt.persistence.DebtEntity;

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
