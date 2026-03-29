package com.guitlog.guitlog.application.usecase.payment;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentEntity;
import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentMapper;
import com.guitlog.guitlog.domain.model.payment.Payment;

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
