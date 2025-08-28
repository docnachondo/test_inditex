package com.example.hexapp.application.rest.impl;

import com.example.hexapp.application.dto.PriceDTO;
import com.example.hexapp.application.mappers.PriceApplicationMapper;
import com.example.hexapp.application.rest.PriceController;
import com.example.hexapp.domain.usecase.PriceUseCase;
import com.example.hexapp.domain.vo.PriceQuery;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class PriceControllerImpl implements PriceController {

    private final PriceUseCase priceUseCase;
    private final PriceApplicationMapper priceMapper;

    @Override
    public PriceDTO priceApply(Long brandId, Long productId, LocalDateTime applicationDate) {
        return priceMapper.toDto(priceUseCase.findApplicablePrice(PriceQuery.builder().brandId(brandId).productId(productId).applicationDate(applicationDate).build()));
    }

}
