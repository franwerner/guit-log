package com.guitlog.guitlog.adapter.out.persistence.wallet;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.adapter.in.rest.dto.CreateWalletRequest;
import com.guitlog.guitlog.domain.model.wallet.Wallet;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currentBalance", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "active", ignore = true)
    Wallet toDomain(CreateWalletRequest request);

    WalletEntity toEntity(Wallet wallet);
}
