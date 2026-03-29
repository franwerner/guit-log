package com.guitlog.guitlog.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.guitlog.guitlog.adapter.out.persistence.category.CategoryEntity;
import com.guitlog.guitlog.domain.model.transaction.TransactionStatus;
import com.guitlog.guitlog.domain.model.transaction.TransactionType;


public record TransactionDetailDTO(
        Long id,
        CategoryEntity category,
        TransactionType type,
        BigDecimal amount,
        String description,
        LocalDate transactionDate,
        TransactionStatus status,
        LocalDateTime createdAt
) {}
