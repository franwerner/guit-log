package com.guitlog.guitlog.features.wallet.presentation.rest.dto;

import java.math.BigDecimal;

import com.guitlog.guitlog.features.wallet.valueObjects.WalletType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateWalletRequest {
    private Long userId;
    private String name;
    private WalletType type;
    private String currency;
    private BigDecimal initialBalance;
}
