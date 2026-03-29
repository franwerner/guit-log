package com.guitlog.guitlog.features.payment.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.payment.application.dto.PaymentDetailDTO;
import com.guitlog.guitlog.features.payment.persistence.PaymentEntity;
import com.guitlog.guitlog.features.payment.presentation.rest.dto.CreatePaymentRequest;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "realValue", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(source = "debtId", target = "debt.id")
    PaymentEntity toEntity(CreatePaymentRequest request);

    PaymentDetailDTO toDetailDTO(PaymentEntity entity);
}
