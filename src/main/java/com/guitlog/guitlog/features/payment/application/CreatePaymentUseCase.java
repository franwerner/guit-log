package com.guitlog.guitlog.features.payment.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.payment.persistence.PaymentEntity;
import com.guitlog.guitlog.features.payment.persistence.PaymentJpaRepository;
import com.guitlog.guitlog.features.payment.persistence.PaymentMapper;
import com.guitlog.guitlog.features.payment.domain.Payment;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreatePaymentUseCase {

    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentMapper paymentMapper;

    public PaymentEntity execute(Payment payment) {
        return paymentJpaRepository.save(paymentMapper.toEntity(payment));
    }
}
