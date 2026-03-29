package com.guitlog.guitlog.budget.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.guitlog.guitlog.category.persistence.CategoryEntity;
import com.guitlog.guitlog.budget.domain.BudgetPeriod;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "budgets")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private CategoryEntity category;

    private BigDecimal limitAmount;

    @Enumerated(EnumType.STRING)
    private BudgetPeriod period;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
}
