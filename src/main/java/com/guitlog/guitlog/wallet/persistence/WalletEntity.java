package com.guitlog.guitlog.wallet.persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.guitlog.guitlog.wallet.domain.WalletType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "wallets")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String name;
    @Enumerated(EnumType.STRING)
    private WalletType type;
    private String currency;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
    private boolean active;
    private LocalDateTime createdAt;
}
