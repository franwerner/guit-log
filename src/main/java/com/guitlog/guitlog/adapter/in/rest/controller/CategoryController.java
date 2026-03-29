package com.guitlog.guitlog.adapter.in.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guitlog.guitlog.adapter.in.rest.dto.CreateCategoryRequest;
import com.guitlog.guitlog.adapter.out.persistence.category.CategoryEntity;
import com.guitlog.guitlog.adapter.out.persistence.category.CategoryMapper;
import com.guitlog.guitlog.application.dto.CategoryDetailDTO;
import com.guitlog.guitlog.application.usecase.category.CreateCategoryUseCase;
import com.guitlog.guitlog.application.usecase.category.GetCategoriesByUserUseCase;
import com.guitlog.guitlog.application.usecase.category.GetCategoryByIdUseCase;
import com.guitlog.guitlog.domain.model.category.Category;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetCategoryByIdUseCase getCategoryByIdUseCase;
    private final GetCategoriesByUserUseCase getCategoriesByUserUseCase;
    private final CategoryMapper categoryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryEntity create(@RequestBody CreateCategoryRequest request) {
        Category category = categoryMapper.toDomain(request);
        return createCategoryUseCase.execute(category);
    }

    @GetMapping("/{id}")
    public CategoryDetailDTO getById(@PathVariable Long id) {
        return getCategoryByIdUseCase.execute(id);
    }

    @GetMapping("/user/{userId}")
    public List<CategoryDetailDTO> getByUserId(@PathVariable Long userId) {
        return getCategoriesByUserUseCase.execute(userId);
    }
}
