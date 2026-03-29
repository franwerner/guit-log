package com.guitlog.guitlog.features.budget.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.budget.application.dto.BudgetDetailDTO;
import com.guitlog.guitlog.features.budget.persistence.BudgetEntity;
import com.guitlog.guitlog.features.budget.presentation.rest.dto.CreateBudgetRequest;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "categoryId", target = "category.id")
    BudgetEntity toEntity(CreateBudgetRequest request);

    BudgetDetailDTO toDetailDTO(BudgetEntity entity);
}
