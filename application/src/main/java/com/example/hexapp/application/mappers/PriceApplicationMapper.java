package com.example.hexapp.application.mappers;

import com.example.hexapp.application.dto.PriceDTO;
import com.example.hexapp.domain.vo.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceApplicationMapper {

    Price toVO(PriceDTO priceDTO);
    PriceDTO toDto(Price price);
}
