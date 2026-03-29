package com.guitlog.guitlog.features.debt.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.debt.persistence.DebtEntity;
import com.guitlog.guitlog.features.debt.presentation.rest.dto.CreateDebtRequest;

@Mapper(componentModel = "spring")
public interface DebtMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "remainingAmount", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    DebtEntity toEntity(CreateDebtRequest request);
}
