package com.guitlog.guitlog.features.debt.application;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guitlog.guitlog.features.debt.persistence.DebtEntity;
import com.guitlog.guitlog.features.debt.persistence.DebtJpaRepository;

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
