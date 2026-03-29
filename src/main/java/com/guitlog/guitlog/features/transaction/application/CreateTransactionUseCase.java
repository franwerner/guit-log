package com.guitlog.guitlog.features.transaction.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.transaction.persistence.TransactionEntity;
import com.guitlog.guitlog.features.transaction.persistence.TransactionJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateTransactionUseCase {

    private final TransactionJpaRepository transactionJpaRepository;

    public TransactionEntity execute(TransactionEntity transaction) {
            return transactionJpaRepository.save(transaction);
    }
}
