package com.guitlog.guitlog.wallet.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.wallet.presentation.CreateWalletRequest;
import com.guitlog.guitlog.wallet.domain.Wallet;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currentBalance", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "active", ignore = true)
    Wallet toDomain(CreateWalletRequest request);

    WalletEntity toEntity(Wallet wallet);
}
