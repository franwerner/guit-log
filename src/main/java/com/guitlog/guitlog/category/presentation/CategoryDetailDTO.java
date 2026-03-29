package com.guitlog.guitlog.category.presentation;

import com.guitlog.guitlog.category.persistence.CategoryEntity;
import com.guitlog.guitlog.category.domain.CategoryType;

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
