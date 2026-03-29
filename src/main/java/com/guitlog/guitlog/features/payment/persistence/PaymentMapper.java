package com.guitlog.guitlog.features.payment.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.payment.presentation.CreatePaymentRequest;
import com.guitlog.guitlog.features.payment.presentation.PaymentDetailDTO;
import com.guitlog.guitlog.features.payment.domain.Payment;

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
