package com.guitlog.guitlog.category.application;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.category.persistence.CategoryJpaRepository;
import com.guitlog.guitlog.category.persistence.CategoryMapper;
import com.guitlog.guitlog.category.presentation.CategoryDetailDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetCategoryByIdUseCase {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    @Transactional(readOnly = true)
    public CategoryDetailDTO execute(Long id) {
        return categoryJpaRepository.findWithDetailsById(id)
                .map(categoryMapper::toDetailDTO)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
    }
}
