package com.guitlog.guitlog.payment.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.payment.presentation.CreatePaymentRequest;
import com.guitlog.guitlog.payment.presentation.PaymentDetailDTO;
import com.guitlog.guitlog.payment.domain.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "realValue", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Payment toDomain(CreatePaymentRequest request);

    @Mapping(source = "debtId", target = "debt.id")
    PaymentEntity toEntity(Payment payment);

    PaymentDetailDTO toDetailDTO(PaymentEntity entity);
}
