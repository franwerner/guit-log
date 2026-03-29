package com.guitlog.guitlog.features.budget.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.budget.presentation.CreateBudgetRequest;
import com.guitlog.guitlog.features.budget.presentation.BudgetDetailDTO;
import com.guitlog.guitlog.features.budget.domain.Budget;

@Mapper(componentModel = "spring", uses = {com.guitlog.guitlog.features.category.persistence.CategoryMapper.class})
public interface BudgetMapper {

    @Mapping(target = "id", ignore = true)
    Budget toDomain(CreateBudgetRequest request);

    @Mapping(source = "categoryId", target = "category.id")
    BudgetEntity toEntity(Budget budget);

    BudgetDetailDTO toDetailDTO(BudgetEntity entity);
}
