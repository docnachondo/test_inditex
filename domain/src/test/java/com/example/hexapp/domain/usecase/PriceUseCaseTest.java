package com.example.hexapp.domain.usecase;

import com.example.hexapp.domain.repository.PriceRepository;
import com.example.hexapp.domain.vo.Price;
import com.example.hexapp.domain.vo.PriceQuery;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PriceUseCaseTest {

    @Test
    void returnsPriceWhenFound() {
        PriceRepository repo = mock(PriceRepository.class);
        PriceUseCase useCase = new PriceUseCase(repo);
        Price expected = new Price(1L, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 1, 35455L, 0, new BigDecimal("35.50"), "EUR");
        PriceQuery query = new PriceQuery(1L, 35455L, LocalDateTime.parse("2020-06-14T10:00:00"));
        when(repo.findByBrandProductAndDate(query)).thenReturn(Optional.of(expected));

        Price result = useCase.findApplicablePrice(query);

        assertEquals(expected.getPrice(), result.getPrice());
        verify(repo, times(1)).findByBrandProductAndDate(query);
    }

    @Test
    void throwsWhenNotFound() {
        PriceRepository repo = mock(PriceRepository.class);
        PriceUseCase useCase = new PriceUseCase(repo);
        PriceQuery query = new PriceQuery(1L, 35455L, LocalDateTime.parse("2020-06-14T22:00:00"));
        when(repo.findByBrandProductAndDate(query)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> useCase.findApplicablePrice(query));
    }
}
