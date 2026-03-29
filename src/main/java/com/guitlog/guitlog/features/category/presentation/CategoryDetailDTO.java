package com.guitlog.guitlog.features.category.presentation;

import com.guitlog.guitlog.features.category.persistence.CategoryEntity;
import com.guitlog.guitlog.features.category.domain.CategoryType;

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
