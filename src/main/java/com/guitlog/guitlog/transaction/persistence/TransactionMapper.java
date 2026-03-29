package com.guitlog.guitlog.transaction.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.transaction.presentation.CreateTransactionRequest;
import com.guitlog.guitlog.category.persistence.CategoryMapper;
import com.guitlog.guitlog.transaction.presentation.TransactionDetailDTO;
import com.guitlog.guitlog.transaction.domain.Transaction;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface TransactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Transaction toDomain(CreateTransactionRequest request);

    @Mapping(target="categoryId",source = "category.id")
    Transaction toDomain(TransactionEntity entity);

    @Mapping(target="category.id",source = "categoryId")
    TransactionEntity toEntity(Transaction transaction);

    TransactionDetailDTO toDetailDTO(TransactionEntity entity);
}
