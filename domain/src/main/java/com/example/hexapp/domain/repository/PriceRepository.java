package com.example.hexapp.domain.repository;

import com.example.hexapp.domain.vo.Price;
import com.example.hexapp.domain.vo.PriceQuery;

import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findByBrandProductAndDate(PriceQuery priceQuery);

    void save(Price price);

}
