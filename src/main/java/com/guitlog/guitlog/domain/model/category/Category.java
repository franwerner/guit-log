package com.guitlog.guitlog.domain.model.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {
    private Long id;
    private Long userId;
    private String name;
    private CategoryType type;
    private Long parentCategoryId;
    private String color;
    private String icon;
    private boolean systemDefined;
}
