package com.guitlog.guitlog.features.transaction.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.guitlog.guitlog.features.category.persistence.CategoryEntity;
import com.guitlog.guitlog.features.transaction.valueObjects.TransactionStatus;
import com.guitlog.guitlog.features.transaction.valueObjects.TransactionType;


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
