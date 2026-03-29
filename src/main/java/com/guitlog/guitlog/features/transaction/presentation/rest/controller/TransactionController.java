package com.guitlog.guitlog.features.transaction.presentation.rest.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guitlog.guitlog.features.transaction.presentation.rest.dto.CreateTransactionRequest;
import com.guitlog.guitlog.features.transaction.persistence.TransactionEntity;
import com.guitlog.guitlog.features.transaction.helper.TransactionMapper;
import com.guitlog.guitlog.features.transaction.application.dto.TransactionDetailDTO;
import com.guitlog.guitlog.features.transaction.application.CreateTransactionUseCase;
import com.guitlog.guitlog.features.transaction.application.GetTransactionByIdUseCase;
import com.guitlog.guitlog.features.transaction.application.GetTransactionsByUserUseCase;
import com.guitlog.guitlog.features.transaction.valueObjects.TransactionStatus;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final CreateTransactionUseCase createTransactionUseCase;
    private final GetTransactionByIdUseCase getTransactionByIdUseCase;
    private final GetTransactionsByUserUseCase getTransactionsByUserUseCase;
    private final TransactionMapper transactionMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionEntity create(@RequestBody CreateTransactionRequest request) {
        TransactionEntity transaction = transactionMapper.toEntity(request);
        transaction.setStatus(TransactionStatus.POSTED);
        transaction.setCreatedAt(LocalDateTime.now());
        return createTransactionUseCase.execute(transaction);
    }

    @GetMapping("/{id}")
    public TransactionDetailDTO getById(@PathVariable Long id) {
        return getTransactionByIdUseCase.execute(id);
    }

    @GetMapping("/user/{userId}")
    public List<TransactionDetailDTO> getByUserId(@PathVariable Long userId) {
        return getTransactionsByUserUseCase.execute(userId);
    }
}
