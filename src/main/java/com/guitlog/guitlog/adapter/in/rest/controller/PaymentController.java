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

import com.guitlog.guitlog.adapter.in.rest.dto.CreatePaymentRequest;
import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentEntity;
import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentMapper;
import com.guitlog.guitlog.application.dto.PaymentDetailDTO;
import com.guitlog.guitlog.application.usecase.payment.CreatePaymentUseCase;
import com.guitlog.guitlog.application.usecase.payment.GetPaymentByIdUseCase;
import com.guitlog.guitlog.application.usecase.payment.GetPaymentsByDebtUseCase;
import com.guitlog.guitlog.domain.model.payment.Payment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final CreatePaymentUseCase createPaymentUseCase;
    private final GetPaymentByIdUseCase getPaymentByIdUseCase;
    private final GetPaymentsByDebtUseCase getPaymentsByDebtUseCase;
    private final PaymentMapper paymentMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentEntity create(@RequestBody CreatePaymentRequest request) {
        Payment payment = paymentMapper.toDomain(request);
        payment.setCreatedAt(LocalDateTime.now());
        return createPaymentUseCase.execute(payment);
    }

    @GetMapping("/{id}")
    public PaymentDetailDTO getById(@PathVariable Long id) {
        return getPaymentByIdUseCase.execute(id);
    }

    @GetMapping("/debt/{debtId}")
    public List<PaymentDetailDTO> getByDebtId(@PathVariable Long debtId) {
        return getPaymentsByDebtUseCase.execute(debtId);
    }
}
