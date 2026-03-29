package com.guitlog.guitlog.category.application;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.category.persistence.CategoryJpaRepository;
import com.guitlog.guitlog.category.persistence.CategoryMapper;
import com.guitlog.guitlog.category.presentation.CategoryDetailDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetCategoriesByUserUseCase {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    @Transactional(readOnly = true)
    public List<CategoryDetailDTO> execute(Long userId) {
        return categoryJpaRepository.findWithDetailsByUserId(userId)
                .stream()
                .map(categoryMapper::toDetailDTO)
                .toList();
    }
}
