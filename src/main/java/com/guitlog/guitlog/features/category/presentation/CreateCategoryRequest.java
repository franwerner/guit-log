package com.guitlog.guitlog.features.category.presentation;

import com.guitlog.guitlog.features.category.domain.CategoryType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCategoryRequest {
    private Long userId;
    private String name;
    private CategoryType type;
    private Long parentCategoryId;
    private String color;
    private String icon;
    private boolean systemDefined;
}
