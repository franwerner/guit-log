package com.guitlog.guitlog.payment.presentation;

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

import com.guitlog.guitlog.payment.presentation.CreatePaymentRequest;
import com.guitlog.guitlog.payment.persistence.PaymentEntity;
import com.guitlog.guitlog.payment.persistence.PaymentMapper;
import com.guitlog.guitlog.payment.presentation.PaymentDetailDTO;
import com.guitlog.guitlog.payment.application.CreatePaymentUseCase;
import com.guitlog.guitlog.payment.application.GetPaymentByIdUseCase;
import com.guitlog.guitlog.payment.application.GetPaymentsByDebtUseCase;
import com.guitlog.guitlog.payment.domain.Payment;

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
