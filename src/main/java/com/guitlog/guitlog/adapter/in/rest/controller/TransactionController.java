package com.guitlog.guitlog.adapter.in.rest.controller;

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

import com.guitlog.guitlog.adapter.in.rest.dto.CreateTransactionRequest;
import com.guitlog.guitlog.adapter.out.persistence.transaction.TransactionEntity;
import com.guitlog.guitlog.adapter.out.persistence.transaction.TransactionMapper;
import com.guitlog.guitlog.application.dto.TransactionDetailDTO;
import com.guitlog.guitlog.application.usecase.transaction.CreateTransactionUseCase;
import com.guitlog.guitlog.application.usecase.transaction.GetTransactionByIdUseCase;
import com.guitlog.guitlog.application.usecase.transaction.GetTransactionsByUserUseCase;
import com.guitlog.guitlog.domain.model.transaction.Transaction;
import com.guitlog.guitlog.domain.model.transaction.TransactionStatus;

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
        Transaction transaction = transactionMapper.toDomain(request);
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
