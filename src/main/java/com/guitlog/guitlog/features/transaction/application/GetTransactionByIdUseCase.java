package com.guitlog.guitlog.features.transaction.application;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.transaction.persistence.TransactionJpaRepository;
import com.guitlog.guitlog.features.transaction.helper.TransactionMapper;
import com.guitlog.guitlog.features.transaction.application.dto.TransactionDetailDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetTransactionByIdUseCase {

    private final TransactionJpaRepository transactionJpaRepository;
    private final TransactionMapper transactionMapper;

    @Transactional(readOnly = true)
    public TransactionDetailDTO execute(Long id) {
        return transactionJpaRepository.findWithDetailsById(id)
                .map(transactionMapper::toDetailDTO)
                .orElseThrow(() -> new RuntimeException("Transaction not found: " + id));
    }
}
