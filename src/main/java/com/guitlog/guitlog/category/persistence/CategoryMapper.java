package com.guitlog.guitlog.category.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.category.presentation.CreateCategoryRequest;
import com.guitlog.guitlog.category.presentation.CategoryDetailDTO;
import com.guitlog.guitlog.category.domain.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    Category toDomain(CreateCategoryRequest request);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "parentCategory.id", target = "parentCategoryId")
    Category toDomain(CategoryEntity entity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "parentCategoryId", target = "parentCategory.id")
    CategoryEntity toEntity(Category category);

    @Mapping(source = "user.id", target = "userId")
    CategoryDetailDTO toDetailDTO(CategoryEntity entity);
}
