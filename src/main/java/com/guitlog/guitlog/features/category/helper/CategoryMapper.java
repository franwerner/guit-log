package com.guitlog.guitlog.features.category.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.category.application.dto.CategoryDetailDTO;
import com.guitlog.guitlog.features.category.persistence.CategoryEntity;
import com.guitlog.guitlog.features.category.presentation.rest.dto.CreateCategoryRequest;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "parentCategoryId", target = "parentCategory.id")
    CategoryEntity toEntity(CreateCategoryRequest request);

    @Mapping(source = "user.id", target = "userId")
    CategoryDetailDTO toDetailDTO(CategoryEntity entity);
}
