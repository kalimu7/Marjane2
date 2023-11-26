package com.brief.marjane2.mapper;

import com.brief.marjane2.dto.PurchaseDto;
import com.brief.marjane2.entity.Purchases;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PurchaseMapper {

    PurchaseMapper inst = Mappers.getMapper(PurchaseMapper.class);

    @Mapping(source = "client.id", target = "clientid")
    @Mapping(source = "product.idP", target = "productid")
    PurchaseDto toDto(Purchases purchases);

    @Mapping(source = "clientid", target = "client.id")
    @Mapping(source = "productid", target = "product.idP")
    Purchases toEntity(PurchaseDto purchaseDto);


}
