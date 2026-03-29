package com.guitlog.guitlog.adapter.out.persistence.transaction;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.guitlog.guitlog.adapter.in.rest.dto.CreateTransactionRequest;
import com.guitlog.guitlog.adapter.out.persistence.category.CategoryMapper;
import com.guitlog.guitlog.application.dto.TransactionDetailDTO;
import com.guitlog.guitlog.domain.model.transaction.Transaction;

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
