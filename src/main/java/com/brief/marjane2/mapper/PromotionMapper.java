package com.brief.marjane2.mapper;

import com.brief.marjane2.dto.PromotionDto;
import com.brief.marjane2.entity.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PromotionMapper {

    PromotionMapper PM = Mappers.getMapper(PromotionMapper.class);
    @Mapping(source = "category.titre",target = "category")
    PromotionDto toDto(Promotion promotion);
    Promotion toEntity( PromotionDto promotionDto);
}
