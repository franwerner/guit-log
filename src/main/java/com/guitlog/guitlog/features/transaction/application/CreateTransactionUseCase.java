package com.guitlog.guitlog.features.transaction.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.transaction.persistence.TransactionEntity;
import com.guitlog.guitlog.features.transaction.persistence.TransactionJpaRepository;
import com.guitlog.guitlog.features.transaction.persistence.TransactionMapper;
import com.guitlog.guitlog.features.transaction.domain.Transaction;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateTransactionUseCase {

    private final TransactionJpaRepository transactionJpaRepository;
    private final TransactionMapper transactionMapper;

    public TransactionEntity execute(Transaction transaction) {
            return transactionJpaRepository.save(transactionMapper.toEntity(transaction));
    }
}
