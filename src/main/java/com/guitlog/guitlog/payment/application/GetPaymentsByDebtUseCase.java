package com.guitlog.guitlog.payment.application;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.payment.persistence.PaymentJpaRepository;
import com.guitlog.guitlog.payment.persistence.PaymentMapper;
import com.guitlog.guitlog.payment.presentation.PaymentDetailDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetPaymentsByDebtUseCase {

    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentMapper paymentMapper;

    @Transactional(readOnly = true)
    public List<PaymentDetailDTO> execute(Long debtId) {
        return paymentJpaRepository.findWithDetailsByDebtId(debtId)
                .stream()
                .map(paymentMapper::toDetailDTO)
                .toList();
    }
}
