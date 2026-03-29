package com.guitlog.guitlog.features.transaction.helper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.features.transaction.application.dto.TransactionDetailDTO;
import com.guitlog.guitlog.features.transaction.persistence.TransactionEntity;
import com.guitlog.guitlog.features.transaction.presentation.rest.dto.CreateTransactionRequest;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(source = "categoryId", target = "category.id")
    TransactionEntity toEntity(CreateTransactionRequest request);

    TransactionDetailDTO toDetailDTO(TransactionEntity entity);
}
