package com.guitlog.guitlog.adapter.out.persistence.payment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.adapter.in.rest.dto.CreatePaymentRequest;
import com.guitlog.guitlog.application.dto.PaymentDetailDTO;
import com.guitlog.guitlog.domain.model.payment.Payment;

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
