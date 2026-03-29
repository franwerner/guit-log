package com.guitlog.guitlog.application.dto;

import com.guitlog.guitlog.adapter.out.persistence.category.CategoryEntity;
import com.guitlog.guitlog.domain.model.category.CategoryType;

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
