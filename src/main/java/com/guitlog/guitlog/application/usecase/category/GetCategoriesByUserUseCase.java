package com.guitlog.guitlog.application.usecase.category;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.adapter.out.persistence.category.CategoryJpaRepository;
import com.guitlog.guitlog.adapter.out.persistence.category.CategoryMapper;
import com.guitlog.guitlog.application.dto.CategoryDetailDTO;

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
