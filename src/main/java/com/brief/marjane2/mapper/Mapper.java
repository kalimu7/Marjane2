package com.brief.marjane2.mapper;

public interface Mapper<E,D> {
    E toEntity(D dto);
    D toDto(E entity);

}
