package com.example.hexapp.infrastructure.mappers;

import com.example.hexapp.domain.vo.Price;
import com.example.hexapp.infrastructure.persistence.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price toVO(PriceEntity entity);
    PriceEntity toEntity(Price domain);
}
