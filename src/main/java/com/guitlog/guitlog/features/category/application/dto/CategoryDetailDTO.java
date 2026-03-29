package com.guitlog.guitlog.features.category.application.dto;

import com.guitlog.guitlog.features.category.persistence.CategoryEntity;
import com.guitlog.guitlog.features.category.valueObjects.CategoryType;

public record CategoryDetailDTO(
        Long id,
        Long userId,
        String name,
        CategoryType type,
        CategoryEntity parentCategory,
        String color,
        String icon,
        boolean systemDefined
) {}
