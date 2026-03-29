package com.guitlog.guitlog.features.category.application;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.features.category.persistence.CategoryEntity;
import com.guitlog.guitlog.features.category.persistence.CategoryJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateCategoryUseCase {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryEntity execute(CategoryEntity category) {
        return categoryJpaRepository.save(category);
    }
}
