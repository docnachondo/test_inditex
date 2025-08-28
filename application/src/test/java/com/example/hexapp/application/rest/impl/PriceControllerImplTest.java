package com.example.hexapp.application.rest.impl;

import com.example.hexapp.application.dto.PriceDTO;
import com.example.hexapp.application.mappers.PriceApplicationMapper;
import com.example.hexapp.domain.usecase.PriceUseCase;
import com.example.hexapp.domain.vo.Price;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PriceControllerImplTest {

    @Test
    void apply200() throws Exception {
        var useCase = Mockito.mock(PriceUseCase.class);
        var mapper  = Mockito.mock(PriceApplicationMapper.class);
        var controller = new PriceControllerImpl(useCase, mapper);

        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();

        var price = new Price(1L,
                LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"),
                1, 35455L, 0, new BigDecimal("35.50"), "EUR");
        var dto = PriceDTO.builder()
                .brandId(1L).productId(35455L).priceList(1)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .priority(0).price(new BigDecimal("35.50")).curr("EUR")
                .build();

        Mockito.when(useCase.findApplicablePrice(any()))
                .thenReturn(price);
        Mockito.when(mapper.toDto(price)).thenReturn(dto);

        mvc.perform(get("/prices/apply")
                        .param("brandId","1")
                        .param("productId","35455")
                        .param("applicationDate","2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.curr").value("EUR"));
    }
}
