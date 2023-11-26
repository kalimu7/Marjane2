package com.brief.marjane2.mapper;
import com.brief.marjane2.dto.CategoryDto;
import com.brief.marjane2.entity.Category;
import  org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategotyMapper {
    CategotyMapper categotyMapper = Mappers.getMapper(CategotyMapper.class);

    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

}

