package com.guitlog.guitlog.features.wallet.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.wallet.presentation.CreateWalletRequest;
import com.guitlog.guitlog.features.wallet.domain.Wallet;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currentBalance", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "active", ignore = true)
    Wallet toDomain(CreateWalletRequest request);

    WalletEntity toEntity(Wallet wallet);
}
