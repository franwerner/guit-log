package com.guitlog.guitlog.features.payment.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.payment.persistence.PaymentEntity;
import com.guitlog.guitlog.features.payment.persistence.PaymentJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreatePaymentUseCase {

    private final PaymentJpaRepository paymentJpaRepository;

    public PaymentEntity execute(PaymentEntity payment) {
        return paymentJpaRepository.save(payment);
    }
}
