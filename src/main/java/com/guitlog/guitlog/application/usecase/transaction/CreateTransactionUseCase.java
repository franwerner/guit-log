package com.guitlog.guitlog.application.usecase.transaction;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.adapter.out.persistence.transaction.TransactionEntity;
import com.guitlog.guitlog.adapter.out.persistence.transaction.TransactionJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.transaction.TransactionMapper;
import com.guitlog.guitlog.domain.model.transaction.Transaction;

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
