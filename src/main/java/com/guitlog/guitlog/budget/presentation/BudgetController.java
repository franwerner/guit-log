package com.guitlog.guitlog.budget.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guitlog.guitlog.budget.presentation.CreateBudgetRequest;
import com.guitlog.guitlog.budget.persistence.BudgetEntity;
import com.guitlog.guitlog.budget.persistence.BudgetMapper;
import com.guitlog.guitlog.budget.presentation.BudgetDetailDTO;
import com.guitlog.guitlog.budget.application.CreateBudgetUseCase;
import com.guitlog.guitlog.budget.application.GetBudgetByIdUseCase;
import com.guitlog.guitlog.budget.application.GetBudgetsByUserUseCase;
import com.guitlog.guitlog.budget.domain.Budget;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/budgets")
@RequiredArgsConstructor
public class BudgetController {

    private final CreateBudgetUseCase createBudgetUseCase;
    private final GetBudgetByIdUseCase getBudgetByIdUseCase;
    private final GetBudgetsByUserUseCase getBudgetsByUserUseCase;
    private final BudgetMapper budgetMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BudgetEntity create(@RequestBody CreateBudgetRequest request) {
        Budget budget = budgetMapper.toDomain(request);
        return createBudgetUseCase.execute(budget);
    }

    @GetMapping("/{id}")
    public BudgetDetailDTO getById(@PathVariable Long id) {
        return getBudgetByIdUseCase.execute(id);
    }

    @GetMapping("/user/{userId}")
    public List<BudgetDetailDTO> getByUserId(@PathVariable Long userId) {
        return getBudgetsByUserUseCase.execute(userId);
    }
}
