package com.guitlog.guitlog.adapter.out.persistence.budget;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.adapter.in.rest.dto.CreateBudgetRequest;
import com.guitlog.guitlog.application.dto.BudgetDetailDTO;
import com.guitlog.guitlog.domain.model.budget.Budget;

@Mapper(componentModel = "spring", uses = {com.guitlog.guitlog.adapter.out.persistence.category.CategoryMapper.class})
public interface BudgetMapper {

    @Mapping(target = "id", ignore = true)
    Budget toDomain(CreateBudgetRequest request);

    @Mapping(source = "categoryId", target = "category.id")
    BudgetEntity toEntity(Budget budget);

    BudgetDetailDTO toDetailDTO(BudgetEntity entity);
}
