package com.brief.marjane2.mapper;

import com.brief.marjane2.dto.ProductDto;
import com.brief.marjane2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface ProductMapper {

    ProductMapper productmapper = Mappers.getMapper(ProductMapper.class);

//    @Mapping(target = "idP", source = "idP")
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
