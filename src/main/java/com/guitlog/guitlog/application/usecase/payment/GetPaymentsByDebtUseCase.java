package com.guitlog.guitlog.application.usecase.payment;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.payment.PaymentMapper;
import com.guitlog.guitlog.application.dto.PaymentDetailDTO;

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
