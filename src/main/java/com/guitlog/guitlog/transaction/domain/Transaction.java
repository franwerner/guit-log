package com.guitlog.guitlog.transaction.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Long userId;
    private Long walletId;
    private Long categoryId;
    private TransactionType type;
    private BigDecimal amount;
    private String description;
    private LocalDate transactionDate;
    private TransactionStatus status;
    private LocalDateTime createdAt;
}
