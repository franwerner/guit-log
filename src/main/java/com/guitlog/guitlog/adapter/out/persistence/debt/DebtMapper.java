package com.guitlog.guitlog.adapter.out.persistence.debt;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.adapter.in.rest.dto.CreateDebtRequest;
import com.guitlog.guitlog.domain.model.debt.Debt;

@Mapper(componentModel = "spring")
public interface DebtMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "remainingAmount", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Debt toDomain(CreateDebtRequest request);

    DebtEntity toEntity(Debt debt);
}
