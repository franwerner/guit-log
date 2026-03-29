package com.guitlog.guitlog.features.category.application;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.category.persistence.CategoryJpaRepository;
import com.guitlog.guitlog.features.category.helper.CategoryMapper;
import com.guitlog.guitlog.features.category.application.dto.CategoryDetailDTO;

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
