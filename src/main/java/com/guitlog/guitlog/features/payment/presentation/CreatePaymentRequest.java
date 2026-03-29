package com.guitlog.guitlog.features.payment.presentation;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePaymentRequest {
    private Long userId;
    private Long debtId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private BigDecimal inflationRate;
}
