package com.guitlog.guitlog.application.usecase.category;

import org.springframework.stereotype.Component;

import com.guitlog.guitlog.adapter.out.persistence.category.CategoryEntity;
import com.guitlog.guitlog.adapter.out.persistence.category.CategoryJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.category.CategoryMapper;
import com.guitlog.guitlog.domain.model.category.Category;

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
