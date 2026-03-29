package com.guitlog.guitlog.adapter.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.guitlog.guitlog.domain.model.transaction.TransactionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTransactionRequest {
    private Long userId;
    private Long walletId;
    private Long categoryId;
    private TransactionType type;
    private BigDecimal amount;
    private String description;
    private LocalDate transactionDate;
}
