package com.guitlog.guitlog.features.transaction.application;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.transaction.persistence.TransactionJpaRepository;
import com.guitlog.guitlog.features.transaction.helper.TransactionMapper;
import com.guitlog.guitlog.features.transaction.application.dto.TransactionDetailDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetTransactionsByUserUseCase {

    private final TransactionJpaRepository transactionJpaRepository;
    private final TransactionMapper transactionMapper;

    @Transactional(readOnly = true)
    public List<TransactionDetailDTO> execute(Long userId) {
        return transactionJpaRepository.findWithDetailsByUserId(userId)
                .stream()
                .map(transactionMapper::toDetailDTO)
                .toList();
    }
}
