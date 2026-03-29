package com.guitlog.guitlog.features.wallet.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Wallet {
    private Long id;
    private Long userId;
    private String name;
    private WalletType type;
    private String currency;
    private BigDecimal initialBalance;
    private BigDecimal currentBalance;
    private boolean active;
    private LocalDateTime createdAt;
}
