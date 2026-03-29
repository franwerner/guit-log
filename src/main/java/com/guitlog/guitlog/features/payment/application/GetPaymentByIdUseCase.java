package com.guitlog.guitlog.features.payment.application;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.payment.persistence.PaymentJpaRepository;
import com.guitlog.guitlog.features.payment.persistence.PaymentMapper;
import com.guitlog.guitlog.features.payment.presentation.PaymentDetailDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetPaymentByIdUseCase {

    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentMapper paymentMapper;

    @Transactional(readOnly = true)
    public PaymentDetailDTO execute(Long id) {
        return paymentJpaRepository.findWithDetailsById(id)
                .map(paymentMapper::toDetailDTO)
                .orElseThrow(() -> new RuntimeException("Payment not found: " + id));
    }
}
