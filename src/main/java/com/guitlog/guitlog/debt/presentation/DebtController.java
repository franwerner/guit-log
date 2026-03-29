package com.guitlog.guitlog.debt.presentation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guitlog.guitlog.debt.presentation.CreateDebtRequest;
import com.guitlog.guitlog.debt.persistence.DebtEntity;
import com.guitlog.guitlog.debt.persistence.DebtMapper;
import com.guitlog.guitlog.debt.application.CreateDebtUseCase;
import com.guitlog.guitlog.debt.application.GetDebtByIdUseCase;
import com.guitlog.guitlog.debt.application.GetDebtsByUserUseCase;
import com.guitlog.guitlog.debt.domain.Debt;
import com.guitlog.guitlog.debt.domain.DebtStatus;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/debts")
@RequiredArgsConstructor
public class DebtController {

    private final CreateDebtUseCase createDebtUseCase;
    private final GetDebtByIdUseCase getDebtByIdUseCase;
    private final GetDebtsByUserUseCase getDebtsByUserUseCase;
    private final DebtMapper debtMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DebtEntity create(@RequestBody CreateDebtRequest request) {
        Debt debt = debtMapper.toDomain(request);
        debt.setRemainingAmount(request.getInitialAmount());
        debt.setStatus(DebtStatus.ACTIVE);
        debt.setCreatedAt(LocalDateTime.now());
        return createDebtUseCase.execute(debt);
    }

    @GetMapping("/{id}")
    public DebtEntity getById(@PathVariable Long id) {
        return getDebtByIdUseCase.execute(id);
    }

    @GetMapping("/user/{userId}")
    public List<DebtEntity> getByUserId(@PathVariable Long userId) {
        return getDebtsByUserUseCase.execute(userId);
    }
}
