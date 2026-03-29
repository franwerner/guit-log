package com.guitlog.guitlog.application.usecase.debt;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.adapter.out.persistence.debt.DebtEntity;
import com.guitlog.guitlog.adapter.out.persistence.debt.DebtJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetDebtsByUserUseCase {

    private final DebtJpaRepository debtJpaRepository;

    @Transactional(readOnly = true)
    public List<DebtEntity> execute(Long userId) {
        return debtJpaRepository.findByUserId(userId);
    }
}
