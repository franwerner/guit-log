package com.guitlog.guitlog.debt.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.debt.presentation.CreateDebtRequest;
import com.guitlog.guitlog.debt.domain.Debt;

@Mapper(componentModel = "spring")
public interface DebtMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "remainingAmount", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Debt toDomain(CreateDebtRequest request);

    DebtEntity toEntity(Debt debt);
}
