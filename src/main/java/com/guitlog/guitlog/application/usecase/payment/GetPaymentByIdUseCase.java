package com.guitlog.guitlog.application.usecase.payment;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentMapper;
import com.guitlog.guitlog.application.dto.PaymentDetailDTO;

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
