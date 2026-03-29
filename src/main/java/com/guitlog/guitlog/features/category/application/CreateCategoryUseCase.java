package com.guitlog.guitlog.features.category.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.category.persistence.CategoryEntity;
import com.guitlog.guitlog.features.category.persistence.CategoryJpaRepository;
import com.guitlog.guitlog.features.category.persistence.CategoryMapper;
import com.guitlog.guitlog.features.category.domain.Category;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateCategoryUseCase {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    public CategoryEntity execute(Category category) {
        return categoryJpaRepository.save(categoryMapper.toEntity(category));
    }
}
