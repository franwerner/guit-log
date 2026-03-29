package com.guitlog.guitlog.payment.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Payment {
    private Long id;
    private Long userId;
    private Long debtId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private BigDecimal inflationRate;
    private BigDecimal realValue;
    private LocalDateTime createdAt;
}
