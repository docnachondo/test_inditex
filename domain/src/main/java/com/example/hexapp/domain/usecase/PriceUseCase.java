package com.example.hexapp.domain.usecase;

import com.example.hexapp.domain.repository.PriceRepository;
import com.example.hexapp.domain.vo.Price;
import com.example.hexapp.domain.vo.PriceQuery;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;

import static com.example.hexapp.domain.constants.PriceMessages.NOT_FOUND_MESSAGE;

@AllArgsConstructor
public class PriceUseCase {

    private final PriceRepository repository;

    public Price findApplicablePrice(PriceQuery priceQuery) throws NoSuchElementException {
        return repository.findByBrandProductAndDate(priceQuery)
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_MESSAGE));
    }

}
