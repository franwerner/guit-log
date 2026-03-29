package com.guitlog.guitlog.features.wallet.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.wallet.persistence.WalletEntity;
import com.guitlog.guitlog.features.wallet.presentation.rest.dto.CreateWalletRequest;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currentBalance", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "active", ignore = true)
    WalletEntity toEntity(CreateWalletRequest request);
}
