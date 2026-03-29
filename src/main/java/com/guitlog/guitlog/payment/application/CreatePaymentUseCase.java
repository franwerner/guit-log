package com.guitlog.guitlog.payment.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.payment.persistence.PaymentEntity;
import com.guitlog.guitlog.payment.persistence.PaymentJpaRepository;
import com.guitlog.guitlog.payment.persistence.PaymentMapper;
import com.guitlog.guitlog.payment.domain.Payment;

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
